package app.main.controllers;

public class BookIdMismatchException extends RuntimeException {

    public BookIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookIdMismatchException() {
        super();
    }

    public BookIdMismatchException(Throwable cause) {
        super(cause);
    }

    public BookIdMismatchException(String message) {
        super(message);
    }

}