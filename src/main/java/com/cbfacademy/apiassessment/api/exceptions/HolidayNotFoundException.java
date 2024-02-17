package com.cbfacademy.apiassessment.api.exceptions;

public class HolidayNotFoundException extends RuntimeException {

    public HolidayNotFoundException(String message) {
        super(message);
    }
}