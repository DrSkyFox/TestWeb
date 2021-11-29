package ru.test;

public class EntityNotExists extends RuntimeException {
    public EntityNotExists() {
    }

    public EntityNotExists(String message) {
        super(message);
    }

    public EntityNotExists(String message, Throwable cause) {
        super(message, cause);
    }
}
