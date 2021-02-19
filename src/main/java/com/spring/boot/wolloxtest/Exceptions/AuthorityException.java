package com.spring.boot.wolloxtest.Exceptions;

public class AuthorityException extends Exception {

    public AuthorityException() {
    }

    public AuthorityException(String message) {
        super(message);
    }

    public AuthorityException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthorityException(Throwable cause) {
        super(cause);
    }

    public AuthorityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
