package com.invillia.acme.user.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException (Long id) {
        super("Could not find user " + id);
    }
}
