package com.company.view.action;

import com.company.exception.DuplicateUserException;

public interface Action {
    String getName();
    void execute() throws DuplicateUserException;

}
