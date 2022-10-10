package com.finanzas.sf.errorhandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConflictException extends RuntimeException {

    public ConflictException() {
        super();
    }

    public ConflictException(String message) {
        super(message);
        log.error(message);
    }


}