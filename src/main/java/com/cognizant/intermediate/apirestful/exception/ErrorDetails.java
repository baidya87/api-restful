package com.cognizant.intermediate.apirestful.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
    private LocalDateTime localDateTime;
    private String errorMessage;
    private String stackTrace;

    public ErrorDetails(){}
    public ErrorDetails(LocalDateTime localDateTime, String errorMessage, String stackTrace){
        this.localDateTime = localDateTime;
        this.errorMessage = errorMessage;
        this.stackTrace = stackTrace;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }
}
