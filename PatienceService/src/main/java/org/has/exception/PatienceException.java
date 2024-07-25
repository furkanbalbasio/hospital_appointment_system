package org.has.exception;

import lombok.Getter;

@Getter
public class PatienceException extends RuntimeException{
    private final ErrorType errorType;

    public PatienceException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public PatienceException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }

}
