package com.jatin.blog.com.jatin.blog.Exceptions;

public class InvalidFileExtensionException extends RuntimeException {
    String fileName;
    String fileType;
    String message;


    public InvalidFileExtensionException(String fileName, String fileType, String message) {
        super(message);
        this.fileName = fileName;
        this.fileType = fileType;
        this.message = message;
    }
}
