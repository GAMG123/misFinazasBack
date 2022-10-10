package com.finanzas.sf.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finanzas.sf.errorhandler.GenericServerException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Slf4j
public class Util {
      public Boolean validateUser(String codigoUsuario) {
        return codigoUsuario != null;
    }
    public static void printUriRequestJson(String location, String uri, Object object) {
        try {
            String url="url";
            String simbol="=========";
            String jsonString="json";
            ObjectMapper objectMapper = new ObjectMapper();
            log.info(simbol, location,simbol);
            log.info(url , uri);
            if (object != null)
            {
                log.info(jsonString , objectMapper.writeValueAsString(object));
            }
            log.info(simbol);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    public static LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }
    public static Optional<URI> createURI(String urlAsString) {
        URI uri;
        try {
            uri = new URI(urlAsString);
        } catch (URISyntaxException uriEx) {
            throw new GenericServerException("Error in TI URL");
        }
        return Optional.of(uri);
    }
    public static <T> void manageRestTemplate(ResponseEntity<T> responseEntity) throws GenericServerException {
        if (responseEntity != null) {
            switch (responseEntity.getStatusCode()) {
                case OK:
                    break;
                case INTERNAL_SERVER_ERROR:
                    throw new GenericServerException("INTERNAL_SERVER_ERROR");
                case FORBIDDEN:
                    throw new GenericServerException("FORBIDDEN");
                case UNAUTHORIZED:
                    throw new GenericServerException("UNAUTHORIZED");
                default:
                    throw new GenericServerException(responseEntity.getStatusCode() +
                            " Ocurrio un error generico consultado al servicio");
            }
        }
    }
    public Boolean validateCellphone(String cellphone) {
        if (cellphone != null) {
            if (!cellphone.matches("\\d{9}")) return false;
            else {
                Pattern pattern = Pattern.compile("^9.*");
                Matcher matcher = pattern.matcher(cellphone);
                return matcher.matches();
            }
        }
        return false;
    }
}
