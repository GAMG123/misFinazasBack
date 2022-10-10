package com.finanzas.sf.errorhandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenericServerException extends RuntimeException {

    private String code;

    public GenericServerException() {
        super();
    }

    public GenericServerException(String message) {
        super(message);
        log.error(message);
    }

    public GenericServerException(String message, String code) {
        super(message);
        this.code = code;
        log.error(message);
    }

    public GenericServerException(Throwable ex) {
        super(ex);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
