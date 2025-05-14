package br.com.jrpbjr.arquivoposicional.exceptions;

public class ErrorMessage {
    private String line;
    private String error;

    // Construtor vazio (substitui @NoArgsConstructor)
    public ErrorMessage() {
    }

    // Construtor com Integer e String
    public ErrorMessage(int linha, String message) {
        this.line = String.valueOf(linha);
        this.error = message;
    }

    // Construtor com String e String
    public ErrorMessage(String linha, String message) {
        this.line = linha;
        this.error = message;
    }

    // Getters e Setters manuais
    public String getLine() {
        return this.line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }

    // Método equals
    @Override
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ErrorMessage)) return false;
        final ErrorMessage other = (ErrorMessage) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$line = this.getLine();
        final Object other$line = other.getLine();
        if (this$line == null ? other$line != null : !this$line.equals(other$line)) return false;
        final Object this$error = this.getError();
        final Object other$error = other.getError();
        if (this$error == null ? other$error != null : !this$error.equals(other$error)) return false;
        return true;
    }

    // Método auxiliar para comparação
    protected boolean canEqual(final Object other) {
        return other instanceof ErrorMessage;
    }

    // Método hashCode
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $line = this.getLine();
        result = result * PRIME + ($line == null ? 43 : $line.hashCode());
        final Object $error = this.getError();
        result = result * PRIME + ($error == null ? 43 : $error.hashCode());
        return result;
    }

    // Método toString
    @Override
    public String toString() {
        return "ErrorMessage(line=" + this.getLine() + ", error=" + this.getError() + ")";
    }
}
