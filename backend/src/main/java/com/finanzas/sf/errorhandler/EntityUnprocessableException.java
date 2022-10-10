package com.finanzas.sf.errorhandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EntityUnprocessableException extends RuntimeException {

    public EntityUnprocessableException() {
        super();
    }

    public EntityUnprocessableException(String message) {
        super(message);
        log.error(message);
    }
}
