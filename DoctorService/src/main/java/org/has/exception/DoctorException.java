package org.has.exception;

import lombok.Getter;

@Getter
public class DoctorException extends RuntimeException{
    private final ErrorType errorType;

    public DoctorException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public DoctorException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }

}
