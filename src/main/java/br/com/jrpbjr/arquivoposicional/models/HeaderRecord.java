package br.com.jrpbjr.arquivoposicional.models;

public class HeaderRecord {

    private String recordType;
    private String companyName;
    private String companyId;
    private String resever;

    // Construtor vazio (equivalente ao @NoArgsConstructor)
    public HeaderRecord() {
    }

    // Construtor completo (equivalente ao @AllArgsConstructor)
    public HeaderRecord(String recordType, String companyName, String companyId, String resever) {
        this.recordType = recordType;
        this.companyName = companyName;
        this.companyId = companyId;
        this.resever = resever;
    }

    // Getters e setters
    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getResever() {
        return resever;
    }

    public void setResever(String resever) {
        this.resever = resever;
    }

    // Método toString (equivalente ao @Data)
    @Override
    public String toString() {
        return "HeaderRecord{" +
                "recordType='" + recordType + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyId='" + companyId + '\'' +
                ", resever='" + resever + '\'' +
                '}';
    }

    // Método equals (equivalente ao @Data)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeaderRecord that = (HeaderRecord) o;
        return recordType.equals(that.recordType) &&
                companyName.equals(that.companyName) &&
                companyId.equals(that.companyId) &&
                resever.equals(that.resever);
    }

    // Método hashCode (equivalente ao @Data)
    @Override
    public int hashCode() {
        int result = recordType.hashCode();
        result = 31 * result + companyName.hashCode();
        result = 31 * result + companyId.hashCode();
        result = 31 * result + resever.hashCode();
        return result;
    }

    // Padrão Builder (equivalente ao @Builder)
    public static HeaderRecordBuilder builder() {
        return new HeaderRecordBuilder();
    }

    public static class HeaderRecordBuilder {
        private String recordType;
        private String companyName;
        private String companyId;
        private String resever;

        public HeaderRecordBuilder recordType(String recordType) {
            this.recordType = recordType;
            return this;
        }

        public HeaderRecordBuilder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public HeaderRecordBuilder companyId(String companyId) {
            this.companyId = companyId;
            return this;
        }

        public HeaderRecordBuilder resever(String resever) {
            this.resever = resever;
            return this;
        }

        public HeaderRecord build() {
            return new HeaderRecord(recordType, companyName, companyId, resever);
        }
    }
}
