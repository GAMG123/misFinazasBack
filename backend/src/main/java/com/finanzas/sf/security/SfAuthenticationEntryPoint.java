package com.finanzas.sf.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finanzas.sf.constants.Constants;
import com.finanzas.sf.errorhandler.Error;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class SfAuthenticationEntryPoint implements AuthenticationEntryPoint{
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        Error wallexError = new Error(HttpStatus.UNAUTHORIZED, Constants.PREFIX_CLIENT_ERROR+ Constants.UNAUTHORIZED);
        wallexError.setMessage("Unauthorized");
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        OutputStream outputStream=response.getOutputStream();
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.writeValue(outputStream, wallexError);
        outputStream.flush();
    }
}
