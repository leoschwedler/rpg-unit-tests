package dev.schwedler.rpgapitests.exception;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Builder
public record ErrorResponse(LocalDateTime timeStamp, HttpStatus status, String error, String message) {

}
