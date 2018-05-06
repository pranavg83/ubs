package com.ubs.opsit.interviews.berlinClock;

import com.ubs.opsit.interviews.berlinClock.exceptions.TimeConverterException;

public interface TimeConverter {

    String convertTime(String aTime) throws TimeConverterException;

}
