package com.example.nameservice;

import jakarta.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(value = UserNotFoundException.class)
  public ResponseEntity<Map<String, String>> handleUserNotFoundExcetion(
      UserNotFoundException e, HttpServletRequest request) {
    Map<String, String> body = Map.of(
        "timestamp", ZonedDateTime.now().toString(),
        "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
        "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
        "message", e.getMessage(),
        "path", request.getRequestURI()
    );
    return new ResponseEntity<Map<String, String>>(body, HttpStatus.NOT_FOUND);
  }
}
