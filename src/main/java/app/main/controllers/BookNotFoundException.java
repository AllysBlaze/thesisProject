package app.main.controllers;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookNotFoundException() {
        super();
    }

    public BookNotFoundException(Throwable cause) {
        super(cause);
    }

    public BookNotFoundException(String message) {
        super(message);
    }

}
