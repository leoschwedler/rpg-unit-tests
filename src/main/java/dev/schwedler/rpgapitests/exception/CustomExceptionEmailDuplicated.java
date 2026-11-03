package dev.schwedler.rpgapitests.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CustomExceptionEmailDuplicated extends ResponseStatusException {
    public CustomExceptionEmailDuplicated(String message) {
        super(HttpStatus.CONFLICT,message);
    }
}
