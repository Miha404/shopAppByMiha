package com.company.exception;

public class DuplicateProductException extends Exception {
    private int id;

    public DuplicateProductException(int id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return String.format("Товар с id = %s уже существуетю", id);
    }
}
