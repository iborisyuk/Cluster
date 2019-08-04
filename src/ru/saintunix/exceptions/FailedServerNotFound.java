package ru.saintunix.exceptions;

public class FailedServerNotFound extends Exception {
    public FailedServerNotFound() {
        super();
    }

    public FailedServerNotFound(String message) {
        super(message);
    }
}
