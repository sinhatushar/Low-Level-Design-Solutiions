package com.rental.vehicle.exceptions;

/**
 * Exception given when the command given is invalid or the command params are invalid.
 */
public class InvalidCommandException extends RuntimeException {
    public InvalidCommandException(String message) {
        super(message);
    }
}