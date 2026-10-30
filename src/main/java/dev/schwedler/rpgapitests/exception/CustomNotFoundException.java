package dev.schwedler.rpgapitests.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


public class CustomNotFoundException extends ResponseStatusException {
    public CustomNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND,message);
    }
}
