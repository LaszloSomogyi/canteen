package com.example.canteen.exceptions;

public class PurchaseItemNotFoundException extends RuntimeException {
    public PurchaseItemNotFoundException(String message) {
        super(message);
    }
}
