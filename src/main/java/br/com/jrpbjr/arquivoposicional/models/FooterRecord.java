package br.com.jrpbjr.arquivoposicional.models;

import java.util.Objects;

public class FooterRecord {

    private String recordType;
    private String footerInfo;

    // Construtor vazio (substitui @NoArgsConstructor)
    public FooterRecord() {
    }

    // Construtor completo (substitui @AllArgsConstructor)
    public FooterRecord(String recordType, String footerInfo) {
        this.recordType = recordType;
        this.footerInfo = footerInfo;
    }

    // Getters e setters
    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getFooterInfo() {
        return footerInfo;
    }

    public void setFooterInfo(String footerInfo) {
        this.footerInfo = footerInfo;
    }

    // Método toString (substitui @Data)
    @Override
    public String toString() {
        return "FooterRecord{" +
                "recordType='" + recordType + '\'' +
                ", footerInfo='" + footerInfo + '\'' +
                '}';
    }

    // Método equals (substitui @Data)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FooterRecord that = (FooterRecord) o;
        return Objects.equals(recordType, that.recordType) &&
                Objects.equals(footerInfo, that.footerInfo);
    }

    // Método hashCode (substitui @Data)
    @Override
    public int hashCode() {
        return Objects.hash(recordType, footerInfo);
    }

    // Builder manual (substitui @Builder)
    public static FooterRecordBuilder builder() {
        return new FooterRecordBuilder();
    }

    public static class FooterRecordBuilder {
        private String recordType;
        private String footerInfo;

        public FooterRecordBuilder recordType(String recordType) {
            this.recordType = recordType;
            return this;
        }

        public FooterRecordBuilder footerInfo(String footerInfo) {
            this.footerInfo = footerInfo;
            return this;
        }

        public FooterRecord build() {
            return new FooterRecord(recordType, footerInfo);
        }
    }
}
