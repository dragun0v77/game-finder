package com.gamefinder.exception;

public class GameNotFoundException extends RuntimeException {
    public GameNotFoundException(String message) {
        super(message); // передаем текст ошибки в RuntimeException
    }
}
