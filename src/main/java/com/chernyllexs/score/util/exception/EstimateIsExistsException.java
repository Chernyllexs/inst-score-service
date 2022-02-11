package com.chernyllexs.score.util.exception;

public class EstimateIsExistsException extends RuntimeException{
    public EstimateIsExistsException(String message) {
        super(message);
    }

    public EstimateIsExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
