package com.gamefinder.exception;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message); // передаем текст ошибки в RuntimeException
    }
}