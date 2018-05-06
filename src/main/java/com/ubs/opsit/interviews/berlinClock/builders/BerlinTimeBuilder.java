package com.ubs.opsit.interviews.berlinClock.builders;

import com.ubs.opsit.interviews.berlinClock.exceptions.TimeConverterException;
import com.ubs.opsit.interviews.berlinClock.transformers.BerlinHourTransformer;
import com.ubs.opsit.interviews.berlinClock.transformers.BerlinMinuteTransformer;
import com.ubs.opsit.interviews.berlinClock.transformers.BerlinSecondTransformer;

public class BerlinTimeBuilder {

    private String secondsIndicator;
    private String minutesIndicator;
    private String hoursIndicator;
    private BerlinHourTransformer berlinHourTransformer = new BerlinHourTransformer();
    private BerlinMinuteTransformer berlinMinuteTransformer = new BerlinMinuteTransformer();
    private BerlinSecondTransformer berlinSecondTransformer = new BerlinSecondTransformer();

    public BerlinTimeBuilder withSeconds(String secondsInterval) throws TimeConverterException {
        secondsIndicator = berlinSecondTransformer.transform(secondsInterval);
        return this;
    }

    public BerlinTimeBuilder withHours(String hourInterval) throws TimeConverterException {
        hoursIndicator = berlinHourTransformer.transform(hourInterval);
        return this;
    }

    public BerlinTimeBuilder withMinutes(String minutesInterval) throws TimeConverterException {
        minutesIndicator = berlinMinuteTransformer.transform(minutesInterval);
        return this;
    }

    public String build() {
        return secondsIndicator + System.lineSeparator() + hoursIndicator + System.lineSeparator() + minutesIndicator;
    }
}
