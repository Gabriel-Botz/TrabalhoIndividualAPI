package org.serratec.TrabalhoIndividualAPI.Exceptions;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

    private int status;
    private String message;
    private long timestamp;

    public ErrorResponse(HttpStatus status, String message) {
        this.status = status.value();
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }
}

