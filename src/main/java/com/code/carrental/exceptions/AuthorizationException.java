package com.code.carrental.exceptions;

public class AuthorizationException extends Exception{
    public AuthorizationException(final String message) throws Exception {
        throw new Exception(message);
    }
}
