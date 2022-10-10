package com.finanzas.sf.errorhandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.finanzas.sf.constants.Constants;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@Slf4j
public class SfExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(HttpStatusCodeException.class)
    protected ResponseEntity<Object> handleHttpRestClient(HttpStatusCodeException ex){
        Error c4f = null;
        if(ex.getStatusCode().is4xxClientError()){
            c4f = new Error(ex.getStatusCode(),
                    Constants.PREFIX_CLIENT_ERROR);
        }else if(ex.getStatusCode().is5xxServerError()){
            c4f = new Error(ex.getStatusCode(),
                    Constants.PREFIX_SERVER_ERROR);
        }
        c4f.setMessage(ex.getMessage());
        log.error("Error HTTP Request Client: {}", ex.getMessage());
        return buildResponseEntity(c4f);
    }


    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
        Error c4f = new Error(HttpStatus.NOT_FOUND,
                Constants.PREFIX_CLIENT_ERROR + Constants.NOT_FOUND);
        c4f.setMessage(ex.getMessage());
        log.error("Entity Not Found: {}", ex.getMessage());
        return buildResponseEntity(c4f);
    }


    @ExceptionHandler(ConflictException.class)
    protected ResponseEntity<Object> handleConflict(ConflictException ex) {
        Error c4f = new Error(HttpStatus.CONFLICT,
                Constants.PREFIX_CLIENT_ERROR + Constants.CONFLICT);
        c4f.setMessage(ex.getMessage());
        log.error("Conflict: {}", ex.getMessage());
        return buildResponseEntity(c4f);
    }

    @ExceptionHandler(EntityUnprocessableException.class)
    protected ResponseEntity<Object> handleUnprocessableEntity(EntityUnprocessableException ex) {
        Error c4f = new Error(HttpStatus.UNPROCESSABLE_ENTITY,
                Constants.PREFIX_CLIENT_ERROR + Constants.UNPROCESSABLE_ENTITY);
        c4f.setMessage(ex.getMessage());
        log.error("Unprocessable Entity: {}", ex.getMessage());
        return buildResponseEntity(c4f);
    }

    @ExceptionHandler(UnauthorizedException.class)
    protected ResponseEntity<Object> handleUnauthorized(UnauthorizedException ex) {
        Error c4f = new Error(HttpStatus.UNAUTHORIZED,
                Constants.PREFIX_CLIENT_ERROR + Constants.UNAUTHORIZED);
        c4f.setMessage(ex.getMessage());
        log.error("Unauthorized: {}", ex.getMessage());
        return buildResponseEntity(c4f);
    }


    @ExceptionHandler(GenericServerException.class)
    protected ResponseEntity<Object> handleGenericServerError(GenericServerException ex) {
        Error c4f = null;
        if(ex.getCode()!=null){
            c4f = new Error(HttpStatus.INTERNAL_SERVER_ERROR, ex.getCode());
        }else{
            c4f = new Error(HttpStatus.INTERNAL_SERVER_ERROR,
                    Constants.PREFIX_SERVER_ERROR + Constants.INTERNAL_SERVER_ERROR);
        }
        c4f.setMessage(ex.getMessage());
        log.error("Internal Server Error: {}", ex.getMessage());
        return buildResponseEntity(c4f);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        Error c4f = new Error(HttpStatus.BAD_REQUEST,
                Constants.PREFIX_CLIENT_ERROR + Constants.BAD_REQUEST);
        c4f.setMessage(ex.getBindingResult().getFieldError().toString());
        c4f.setSubErrors(fillValidationErrorsFrom(ex));
        log.error("Bad Request: {}", ex.getBindingResult().getFieldError().toString());
        return buildResponseEntity(c4f);
    }

    @ExceptionHandler(GenericClientException.class)
    protected ResponseEntity<Object> handleGenericClientException(GenericClientException ex) {
        Error c4f = new Error(ex.getHttpStatus(),
                Constants.PREFIX_CLIENT_ERROR);
        c4f.setMessage(ex.getMessage());
        c4f.setSubErrors(ex.getSubErrors());
        log.error("Client Error: {}", ex.getMessage());
        return buildResponseEntity(c4f);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleError(Exception ex) {
        Error civilAgreementError = new Error(HttpStatus.INTERNAL_SERVER_ERROR,
                Constants.PREFIX_SERVER_ERROR + Constants.INTERNAL_SERVER_ERROR);
        civilAgreementError.setMessage("Error generico de servidor " + ex.getMessage());
        log.error("Server Error: {}", ex.getMessage());
        return buildResponseEntity(civilAgreementError);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        String error = "Malformed JSON request";
        return buildResponseEntity(new Error(HttpStatus.BAD_REQUEST,
                Constants.PREFIX_CLIENT_ERROR + Constants.BAD_REQUEST, error, ex));
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
                                                                          HttpHeaders headers, HttpStatus status,
                                                                          WebRequest request) {
        String error = ex.getParameterName() + " parameter is missing";
        log.error("Bad Request: {}", error);
        return buildResponseEntity(new Error(HttpStatus.BAD_REQUEST,
                Constants.PREFIX_CLIENT_ERROR + Constants.BAD_REQUEST, error, ex));
    }

    private ResponseEntity<Object> buildResponseEntity(Error civilAgreementError) {
        return new ResponseEntity<>(civilAgreementError, civilAgreementError.getHttpStatus());
    }

    protected List<SubError> fillValidationErrorsFrom(MethodArgumentNotValidException argumentNotValid) {
        List<SubError> subErrorCollection = new ArrayList<>();
        argumentNotValid.getBindingResult().getFieldErrors().get(0).getRejectedValue();
        argumentNotValid.getBindingResult().getFieldErrors().stream().forEach((objError) -> {
            SubError civilAgreementSubError = new ValidationError(objError.getObjectName(),
                    objError.getField(), objError.getRejectedValue(), objError.getDefaultMessage());
            subErrorCollection.add(civilAgreementSubError);
        });
        return subErrorCollection;
    }

}
