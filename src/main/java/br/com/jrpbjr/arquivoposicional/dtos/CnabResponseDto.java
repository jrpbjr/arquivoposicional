package br.com.jrpbjr.arquivoposicional.dtos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import br.com.jrpbjr.arquivoposicional.entities.CnabDat;
import br.com.jrpbjr.arquivoposicional.models.TransactionRecord;

public class CnabResponseDto {

    private String status;
    private String message;
    private Data data = new Data();

    // Construtor vazio
    public CnabResponseDto() {
    }

    // Construtor com CnabDat
    public CnabResponseDto(CnabDat cnabDat) {
        this.status = "success";
        this.message = "Arquivo CNAB enviado e processado com sucesso.";
        this.data.transactions = new Data(cnabDat.getTransactions()).getTransactions();
    }

    // Getters e setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {

        private List<Transaction> transactions = new ArrayList<>();

        // Construtor vazio
        public Data() {
        }

        // Construtor com lista de TransactionRecord
        public Data(List<TransactionRecord> transactionsRecords) {
            this.transactions = transactionsRecords.stream().map(Transaction::new).collect(Collectors.toList());
        }

        // Getters e setters
        public List<Transaction> getTransactions() {
            return transactions;
        }

        public void setTransactions(List<Transaction> transactions) {
            this.transactions = transactions;
        }

        public static class Transaction {

            private String type;
            private BigDecimal value;
            private String accountOrigin;
            private String accountDestination;

            // Construtor vazio
            public Transaction() {
            }

            // Construtor com TransactionRecord
            public Transaction(TransactionRecord transaction) {
                this.type = transaction.getRecordType();
                this.value = transaction.getTransactionValue();
                this.accountOrigin = transaction.getSourceAccount();
                this.accountDestination = transaction.getDestinationAccount();
            }

            // Getters e setters
            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public BigDecimal getValue() {
                return value;
            }

            public void setValue(BigDecimal value) {
                this.value = value;
            }

            public String getAccountOrigin() {
                return accountOrigin;
            }

            public void setAccountOrigin(String accountOrigin) {
                this.accountOrigin = accountOrigin;
            }

            public String getAccountDestination() {
                return accountDestination;
            }

            public void setAccountDestination(String accountDestination) {
                this.accountDestination = accountDestination;
            }
        }
    }
}

