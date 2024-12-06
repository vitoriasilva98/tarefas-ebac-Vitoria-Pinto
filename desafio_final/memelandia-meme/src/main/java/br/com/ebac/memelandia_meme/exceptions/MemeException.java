package br.com.ebac.memelandia_meme.exceptions;

public class MemeException extends RuntimeException {
    public MemeException(String message) {
        super(message);
    }

    public MemeException() {
        super();
    }

    public MemeException(Exception ex) {
        super(ex);
    }
}
