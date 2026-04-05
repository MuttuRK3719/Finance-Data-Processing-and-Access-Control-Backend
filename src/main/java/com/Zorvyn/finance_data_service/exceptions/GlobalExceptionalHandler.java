package com.Zorvyn.finance_data_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionalHandler {
    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<String> handleUserNotFound(UserNotFound ex) {
        return new  ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(FileRecordNotFound.class)
    public ResponseEntity<String> handleUserNotFound(FileRecordNotFound ex) {
        return new  ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DuplicateUser.class)
    public ResponseEntity<String> handleUserNotFound(DuplicateUser ex) {
        return new  ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(NoRecordExists.class)
    public ResponseEntity<String> handleUserNotFound(NoRecordExists ex) {
        return new  ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleUserNotFound(RuntimeException ex) {
        return new  ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
