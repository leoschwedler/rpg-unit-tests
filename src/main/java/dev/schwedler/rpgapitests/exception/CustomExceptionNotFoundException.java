package dev.schwedler.rpgapitests.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


public class CustomExceptionNotFoundException extends ResponseStatusException {
    public CustomExceptionNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND,message);
    }
}
