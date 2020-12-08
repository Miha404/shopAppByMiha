package com.company.view.console;

import com.company.exception.DuplicateUserException;

public interface ApplicationWork {
    void run() throws DuplicateUserException;
    void showMenu();

}
