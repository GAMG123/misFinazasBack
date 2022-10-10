package com.finanzas.sf.errorhandler;

import lombok.Data;

@Data
public class ValidationError extends SubError {
    private String object;
    private String field;
    private Object rejectValue;
    private String message;

    public ValidationError(String object, String message) {
        this.object = object;
        this.message = message;
    }

    public ValidationError(String object, String field, Object rejectValue, String message) {
        this.object = object;
        this.field = field;
        this.rejectValue = rejectValue;
        this.message = message;
    }
}
