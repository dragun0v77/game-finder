package com.gamefinder.exception;

import java.time.LocalDateTime; // класс, хранящий дату и время
import java.time.format.DateTimeFormatter; // класс, который форматирует дату и время в строку

public class ErrorResponse {
    private final int status;
    private final String message;
    private final String timestamp;

    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
