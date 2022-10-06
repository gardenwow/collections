package com.exampleskypro.collections;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadExep extends RuntimeException{
    public BadExep() {
    }

    public BadExep(String message) {
        super(message);
    }

    public BadExep(String message, Throwable cause) {
        super(message, cause);
    }

    public BadExep(Throwable cause) {
        super(cause);
    }

    public BadExep(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
