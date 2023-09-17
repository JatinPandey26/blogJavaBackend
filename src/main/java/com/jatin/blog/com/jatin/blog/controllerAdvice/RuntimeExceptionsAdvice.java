package com.jatin.blog.com.jatin.blog.controllerAdvice;

import com.jatin.blog.com.jatin.blog.Exceptions.InvalidFileExtensionException;
import com.jatin.blog.com.jatin.blog.Exceptions.ResourceNotFoundException;
import com.jatin.blog.com.jatin.blog.Payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RuntimeExceptionsAdvice {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
        return new ResponseEntity<ApiResponse>(new ApiResponse(resourceNotFoundException.getMessage(),false), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidFileExtensionException.class)
    public ResponseEntity<ApiResponse> handleInvalidFileExtensionException(InvalidFileExtensionException invalidFileExtensionException){
        return new ResponseEntity<ApiResponse>(new ApiResponse(invalidFileExtensionException.getMessage(),false),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
