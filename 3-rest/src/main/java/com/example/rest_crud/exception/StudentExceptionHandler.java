package com.example.rest_crud.exception;

import com.example.rest_crud.dto.StudentErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException error) {
        var status = HttpStatus.NOT_FOUND;
        var response = new StudentErrorResponse(status, error.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception error) {
        var status = HttpStatus.BAD_REQUEST;
        var response = new StudentErrorResponse(status, error.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, status);
    }
}
