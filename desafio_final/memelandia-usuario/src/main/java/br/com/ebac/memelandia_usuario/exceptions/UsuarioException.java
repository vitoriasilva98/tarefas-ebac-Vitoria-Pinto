package br.com.ebac.memelandia_usuario.exceptions;

public class UsuarioException extends RuntimeException {
    public UsuarioException(String message) {
        super(message);
    }

    public UsuarioException() {
        super();
    }

    public UsuarioException(Exception ex) {
        super(ex);
    }
}
