package com.company.exception;

public class DuplicateUserException extends Exception {
    private String name;

    public DuplicateUserException(String name){
        this.name = name;
    }
    @Override
    public String getMessage() {
        return String.format("Пользователь с именем \"%s\" уже существуетю", name);
    }
}
