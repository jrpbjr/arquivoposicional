package br.com.jrpbjr.arquivoposicional.entities;

import java.io.Serializable;
import java.util.List;

import br.com.jrpbjr.arquivoposicional.models.FooterRecord;
import br.com.jrpbjr.arquivoposicional.models.HeaderRecord;
import br.com.jrpbjr.arquivoposicional.models.TransactionRecord;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cnab")
public class CnabDat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private HeaderRecord header;
    private List<TransactionRecord> transactions;
    private FooterRecord footer;
}
