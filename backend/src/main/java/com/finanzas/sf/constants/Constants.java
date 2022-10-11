package com.finanzas.sf.constants;

public class Constants {
    private Constants(){}
    public static final String API_VERSION = "v1";
    // ERRORS
    public static final String PREFIX_SERVER_ERROR = "SRV";
    public static final String PREFIX_CLIENT_ERROR = "CLI";
    // CLIENT ERRORS
    public static final String UNPROCESSABLE_ENTITY =  "003";
    public static final String BAD_REQUEST = "001";
    public static final String UNAUTHORIZED = "002";
    public static final String NOT_FOUND = "004";
    public static final String CONFLICT = "009";

    // SERVER ERRORS
    public static final String INTERNAL_SERVER_ERROR = "001";
    public static final String RESOURCE_ROLS = "/rols";
    public static final String RESOURCE_EXPENSES = "/expenses";
    public static final String RESOURCE_INDICADOR = "/indicador";
    public static final String RESOURCE_PERIODOS= "/periodos";

    public static final Integer RESOURCE_ACTIVE= 1;
    
    public static final String REQ_HEADER_AUTHORIZATE = "Authorization";
    
    public static final String RESOURCE_SAVE = "/save";
    public static final String RESOURCE_DELETE = "/delete";
    
    //Usuario
    public static final String RESOURCE_USUARIO = "/users";
    
    public static final String RESOURCE_USUARIO_LOGIN ="/login";
    public static final String RESOURCE_USUARIO_GUARDAR ="/save";
    
    //Datos
    public static final String RESOURCE_INCOME = "/income";
    
    //Areas
    public static final String RESOURCE_CATEGORYS = "/categorys";
    public static final String RESOURCE_CATEGORY = "/category";
    
}
