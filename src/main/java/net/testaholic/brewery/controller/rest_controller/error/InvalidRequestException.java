package net.testaholic.brewery.controller.rest_controller.error;

import org.springframework.validation.Errors;

/**
 * Created by williamrussell on 6/9/16.
 */
@SuppressWarnings("serial")
public class InvalidRequestException extends RuntimeException {
    private Errors errors;

    public InvalidRequestException(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }

    public Errors getErrors() { return errors; }
}
