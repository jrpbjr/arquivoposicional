package br.com.jrpbjr.arquivoposicional.service;

import java.io.BufferedReader;
import java.io.IOException;
//impot bigdecimal
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.jrpbjr.arquivoposicional.entities.CnabDat;
import br.com.jrpbjr.arquivoposicional.exceptions.ErrorMessage;
import br.com.jrpbjr.arquivoposicional.exceptions.InvalidPosicionalFileException;
import br.com.jrpbjr.arquivoposicional.exceptions.InvalidPosicionalFormatException;
import br.com.jrpbjr.arquivoposicional.models.FooterRecord;
import br.com.jrpbjr.arquivoposicional.models.HeaderRecord;
import br.com.jrpbjr.arquivoposicional.models.TransactionRecord;
import br.com.jrpbjr.arquivoposicional.repository.CnabDatRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class CnabFileService {

    private static final Logger log = LoggerFactory.getLogger(CnabFileService.class);

    private final String MESSAGE_ERROR = "Erro ao processar o arquivo CNAB. Certifique-se de que o arquivo esteja no formato posicional correto.";

    private final CnabDatRepository cnabDatRepository;

    public CnabFileService(CnabDatRepository cnabDatRepository) {
        this.cnabDatRepository = cnabDatRepository;
    }

    public CnabDat cnabFilePosicional(final MultipartFile cnabFile) {
        List<TransactionRecord> transactions = new ArrayList<>();
        List<ErrorMessage> errors = new ArrayList<>();
        HeaderRecord header = null;
        FooterRecord footer = null;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(cnabFile.getInputStream()))) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                String recordType = line.substring(0, 3);

                switch (recordType) {
                    case "001": // Header
                        log.info("Processando header na linha {}", lineNumber);
                        header = parseHeader(line);
                        break;

                    case "002": // Transação
                        log.info("Processando transação na linha {}", lineNumber);
                        TransactionRecord transaction = parseTransaction(line, lineNumber, errors);
                        if (transaction != null) {
                            transactions.add(transaction);
                        }
                        break;

                    case "003": // Footer
                        log.info("Processando footer na linha {}", lineNumber);
                        footer = parseFooter(line);
                        break;

                    default:
                        log.warn("Tipo de registro inválido: '{}', na linha {}", recordType, lineNumber);
                        errors.add(new ErrorMessage(lineNumber, "Tipo de registro inválido: " + recordType));
                }
            }

            if (footer == null || header == null) {
                throw new InvalidPosicionalFileException("ERROR", MESSAGE_ERROR);
            }

        } catch (IOException e) {
            log.error("Erro ao ler o arquivo CNAB: {}", e.getMessage());
            throw new InvalidPosicionalFileException("ERROR", MESSAGE_ERROR);
        }

        // Salvar as informações no MongoDB
        CnabDat cnabDat = new CnabDat(null, header, transactions, footer);
        return cnabDatRepository.save(cnabDat);
    }

    private HeaderRecord parseHeader(final String line) {
        try {
            String recordType = line.substring(0, 3);
            String companyName = line.substring(3, 23).trim();
            String companyId = line.substring(23, 37).trim();
            String resever = line.substring(37).trim();

            return new HeaderRecord(recordType, companyName, companyId, resever);
        } catch (Exception e) {
            throw new InvalidPosicionalFileException("ERROR", "Erro ao parsear o HEADER!");
        }
    }

    private TransactionRecord parseTransaction(final String line, int lineNumber, List<ErrorMessage> errors) {
        try {
            String recordType = line.substring(0, 3);
            String transactionType = line.substring(3, 4);
            String transactionValueString = line.substring(4, 18).trim();
            String sourceAccount = line.substring(18, 28).trim();
            String destinationAccount = line.substring(28).trim();

            BigDecimal transactionValue = new BigDecimal(transactionValueString).movePointLeft(2);

            return new TransactionRecord(recordType, transactionType, transactionValue, sourceAccount, destinationAccount);
        } catch (Exception e) {
            log.error("Erro ao processar transação na linha {}: {}", lineNumber, e.getMessage());
            errors.add(new ErrorMessage(lineNumber, "Erro ao processar linha: " + line));
            return null;
        }
    }

    private FooterRecord parseFooter(final String line) {
        try {
            String recordType = line.substring(0, 3);
            String footerInfo = line.substring(3).trim();

            return new FooterRecord(recordType, footerInfo);
        } catch (Exception e) {
            throw new InvalidPosicionalFileException("ERROR", "Erro ao parsear o FOOTER!");
        }
    }
}
