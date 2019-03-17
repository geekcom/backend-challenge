package com.invillia.acme.store.exception;

public class StoreNotFoundException extends RuntimeException {

    public StoreNotFoundException (Long id) {
        super("Could not find store " + id);
    }
}
