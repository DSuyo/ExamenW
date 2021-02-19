package com.spring.boot.wolloxtest.Exceptions;

import feign.FeignException.FeignClientException;
import feign.Request;

import java.nio.ByteBuffer;
import java.util.Optional;

public class UserException extends FeignClientException {

    public UserException(int status, String message, Request request, Optional<ByteBuffer> body) {
        super(status, message, request, new byte[ body.get().remaining()]);
    }

}
