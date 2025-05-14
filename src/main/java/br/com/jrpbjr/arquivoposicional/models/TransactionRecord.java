package br.com.jrpbjr.arquivoposicional.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class TransactionRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    private String recordType;
    private String transactionType;
    private BigDecimal transactionValue;
    private String sourceAccount;
    private String destinationAccount;

    // Construtor vazio (substitui @NoArgsConstructor)
    public TransactionRecord() {
    }

    // Construtor completo (substitui @AllArgsConstructor)
    public TransactionRecord(String recordType, String transactionType, BigDecimal transactionValue, String sourceAccount, String destinationAccount) {
        this.recordType = recordType;
        this.transactionType = transactionType;
        this.transactionValue = transactionValue;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
    }

    // Getters e setters
    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(BigDecimal transactionValue) {
        this.transactionValue = transactionValue;
    }

    public String getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(String sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public String getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(String destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    // Método toString (substitui @Data)
    @Override
    public String toString() {
        return "TransactionRecord{" +
                "recordType='" + recordType + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", transactionValue=" + transactionValue +
                ", sourceAccount='" + sourceAccount + '\'' +
                ", destinationAccount='" + destinationAccount + '\'' +
                '}';
    }

    // Métodos equals e hashCode (substituem @Data)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionRecord that = (TransactionRecord) o;
        return Objects.equals(recordType, that.recordType) &&
                Objects.equals(transactionType, that.transactionType) &&
                Objects.equals(transactionValue, that.transactionValue) &&
                Objects.equals(sourceAccount, that.sourceAccount) &&
                Objects.equals(destinationAccount, that.destinationAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordType, transactionType, transactionValue, sourceAccount, destinationAccount);
    }

    // Builder manual (substitui @Builder)
    public static TransactionRecordBuilder builder() {
        return new TransactionRecordBuilder();
    }

    public static class TransactionRecordBuilder {
        private String recordType;
        private String transactionType;
        private BigDecimal transactionValue;
        private String sourceAccount;
        private String destinationAccount;

        public TransactionRecordBuilder recordType(String recordType) {
            this.recordType = recordType;
            return this;
        }

        public TransactionRecordBuilder transactionType(String transactionType) {
            this.transactionType = transactionType;
            return this;
        }

        public TransactionRecordBuilder transactionValue(BigDecimal transactionValue) {
            this.transactionValue = transactionValue;
            return this;
        }

        public TransactionRecordBuilder sourceAccount(String sourceAccount) {
            this.sourceAccount = sourceAccount;
            return this;
        }

        public TransactionRecordBuilder destinationAccount(String destinationAccount) {
            this.destinationAccount = destinationAccount;
            return this;
        }

        public TransactionRecord build() {
            return new TransactionRecord(recordType, transactionType, transactionValue, sourceAccount, destinationAccount);
        }
    }
}

