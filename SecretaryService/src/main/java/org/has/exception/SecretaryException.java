package org.has.exception;

import lombok.Getter;

@Getter
public class SecretaryException extends RuntimeException{
    private final ErrorType errorType;

    public SecretaryException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public SecretaryException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }

}
