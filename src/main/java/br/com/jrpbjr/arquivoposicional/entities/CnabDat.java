package br.com.jrpbjr.arquivoposicional.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import br.com.jrpbjr.arquivoposicional.models.FooterRecord;
import br.com.jrpbjr.arquivoposicional.models.HeaderRecord;
import br.com.jrpbjr.arquivoposicional.models.TransactionRecord;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "cnab")
public class CnabDat implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private HeaderRecord header;
    private List<TransactionRecord> transactions;
    private FooterRecord footer;

    // Construtor vazio (substitui @NoArgsConstructor)
    public CnabDat() {
    }

    // Construtor completo (substitui @AllArgsConstructor)
    public CnabDat(String id, HeaderRecord header, List<TransactionRecord> transactions, FooterRecord footer) {
        this.id = id;
        this.header = header;
        this.transactions = transactions;
        this.footer = footer;
    }

    // Getters e setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HeaderRecord getHeader() {
        return header;
    }

    public void setHeader(HeaderRecord header) {
        this.header = header;
    }

    public List<TransactionRecord> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionRecord> transactions) {
        this.transactions = transactions;
    }

    public FooterRecord getFooter() {
        return footer;
    }

    public void setFooter(FooterRecord footer) {
        this.footer = footer;
    }

    // Método toString (substitui @Data)
    @Override
    public String toString() {
        return "CnabDat{" +
                "id='" + id + '\'' +
                ", header=" + header +
                ", transactions=" + transactions +
                ", footer=" + footer +
                '}';
    }

    // Método equals (substitui @Data)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CnabDat cnabDat = (CnabDat) o;
        return Objects.equals(id, cnabDat.id) &&
                Objects.equals(header, cnabDat.header) &&
                Objects.equals(transactions, cnabDat.transactions) &&
                Objects.equals(footer, cnabDat.footer);
    }

    // Método hashCode (substitui @Data)
    @Override
    public int hashCode() {
        return Objects.hash(id, header, transactions, footer);
    }

    // Builder interno (substitui @Builder)
    public static CnabDatBuilder builder() {
        return new CnabDatBuilder();
    }

    public static class CnabDatBuilder {
        private String id;
        private HeaderRecord header;
        private List<TransactionRecord> transactions;
        private FooterRecord footer;

        public CnabDatBuilder id(String id) {
            this.id = id;
            return this;
        }

        public CnabDatBuilder header(HeaderRecord header) {
            this.header = header;
            return this;
        }

        public CnabDatBuilder transactions(List<TransactionRecord> transactions) {
            this.transactions = transactions;
            return this;
        }

        public CnabDatBuilder footer(FooterRecord footer) {
            this.footer = footer;
            return this;
        }

        public CnabDat build() {
            return new CnabDat(id, header, transactions, footer);
        }
    }
}
