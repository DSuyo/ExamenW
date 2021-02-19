package com.spring.boot.wolloxtest.Exceptions;

public class AlbumUserException extends Exception{
    public AlbumUserException() {
    }

    public AlbumUserException(String message) {
        super(message);
    }

    public AlbumUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlbumUserException(Throwable cause) {
        super(cause);
    }

    public AlbumUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
