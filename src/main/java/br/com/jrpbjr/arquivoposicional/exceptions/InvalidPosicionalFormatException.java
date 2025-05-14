package br.com.jrpbjr.arquivoposicional.exceptions;

import java.util.List;

public class InvalidPosicionalFormatException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String status;
    private List<ErrorMessage> errors;

    // Construtor
    public InvalidPosicionalFormatException(String status, String message, List<ErrorMessage> errors) {
        super(message);
        this.status = status;
        this.errors = errors;
    }

    // Getters
    public String getStatus() {
        return status;
    }

    public List<ErrorMessage> getErrors() {
        return errors;
    }

    // Setters
    public void setStatus(String status) {
        this.status = status;
    }

    public void setErrors(List<ErrorMessage> errors) {
        this.errors = errors;
    }
}
