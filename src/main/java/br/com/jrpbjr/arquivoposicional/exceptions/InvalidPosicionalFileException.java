package br.com.jrpbjr.arquivoposicional.exceptions;

public class InvalidPosicionalFileException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String status;

    // Construtor
    public InvalidPosicionalFileException(String status, String message) {
        super(message);
        this.status = status;
    }

    // Getter manual para o atributo 'status'
    public String getStatus() {
        return status;
    }

    // Setter manual para o atributo 'status'
    public void setStatus(String status) {
        this.status = status;
    }
}

