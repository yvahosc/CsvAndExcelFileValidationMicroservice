package org.makaia.fileRecordValidator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice()
public class ApiExceptionHandler {

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<ValidationException> handleNotValueExeption(ApiException e){
        ValidationException exception = new ValidationException(e.getStatusCode(), e.getMessage());
        return new ResponseEntity<ValidationException>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<ValidationException> handleBodyNull(HttpMessageNotReadableException e){
        ValidationException exception = new ValidationException(400,
                e.getMessage());
        return new ResponseEntity<ValidationException>(exception,
                HttpStatus.BAD_REQUEST);
    }
}