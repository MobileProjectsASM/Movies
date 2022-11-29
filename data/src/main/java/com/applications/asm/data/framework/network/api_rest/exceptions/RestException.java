package com.applications.asm.data.framework.network.api_rest.exceptions;

public class RestException extends Exception {
    private final Integer code;
    private final String message;

    public RestException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}