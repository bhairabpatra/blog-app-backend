package com.blog.app.exception;

public class BlogApiException extends RuntimeException{
    public BlogApiException() {
    }

    public BlogApiException(String message) {
        super(message);
    }
}
