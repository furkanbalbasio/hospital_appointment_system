package org.has.exception;

import lombok.Getter;

@Getter
public class AppointmentException extends RuntimeException{
    private final ErrorType errorType;

    public AppointmentException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public AppointmentException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }

}
