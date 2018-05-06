package com.ubs.opsit.interviews.berlinClock;

import com.ubs.opsit.interviews.berlinClock.exceptions.TimeConverterException;
import org.junit.Before;
import org.junit.Test;

public class BerlinTimeConverterTest {

    private TimeConverter timeConverter;

    @Before
    public void setup(){
        timeConverter = new BerlinTimeConverter();
    }

    @Test(expected = TimeConverterException.class)
    public void testException() throws TimeConverterException {
        timeConverter.convertTime("24:00");
    }

}
