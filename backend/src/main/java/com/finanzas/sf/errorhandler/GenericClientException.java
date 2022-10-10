package com.finanzas.sf.errorhandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.util.List;

@Slf4j
public class GenericClientException extends RuntimeException {

    private HttpStatus httpStatus;
    private List<SubError> subErrors;
    private String logType;

    public GenericClientException() {
        super();
    }

    public GenericClientException(String message, Throwable ex) {
        super(message, ex);
    }

    public GenericClientException(String message) {
        super(message);
    }

    public GenericClientException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
        log.error(message);
    }

    public GenericClientException(String message, HttpStatus httpStatus,
                                     List<SubError> subErrors) {
        super(message);
        this.httpStatus = httpStatus;
        this.subErrors = subErrors;
        log.error(message);
    }

    public GenericClientException(Throwable ex) {
        super(ex);
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public List<SubError> getSubErrors() {
        return subErrors;
    }

    public void setSubErrors(List<SubError> subErrors) {
        this.subErrors = subErrors;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }
}
