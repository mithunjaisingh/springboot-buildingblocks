package com.stacksimplify.restservices.exceptions;

import java.util.Date;

public class CustomErrorDetails {
    private Date time;
    private String message;
    private String errorDetails;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }

    public CustomErrorDetails(Date time, String message, String errorDetails) {
        this.time = time;
        this.message = message;
        this.errorDetails = errorDetails;
    }
}
