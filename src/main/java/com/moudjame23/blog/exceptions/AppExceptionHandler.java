package com.moudjame23.blog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleInvalidArguments(MethodArgumentNotValidException exception)
    {
        ApiError apiError = new ApiError();
        apiError.setMessage("Les informations fournies contiennent des erreurs");
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());

        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        apiError.setErrors(errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(apiError);
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFoundResource(ResourceNotFoundException exception)
    {
        ApiError apiError = new ApiError();
        apiError.setStatus(HttpStatus.NOT_FOUND.value());
        apiError.setMessage(exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(apiError);
    }
}
