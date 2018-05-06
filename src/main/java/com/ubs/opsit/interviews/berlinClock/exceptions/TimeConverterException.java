package com.ubs.opsit.interviews.berlinClock.exceptions;

public class TimeConverterException extends Exception {

    public TimeConverterException(String message, Exception e) {
        super(message,e);
    }
}
