package com.leonp967.winestore.exception;

public class ClientsQueryException extends Exception {

    public ClientsQueryException(String message, Exception cause) {
        super(message, cause);
    }

    public ClientsQueryException(String message) {
        super(message);
    }
}
