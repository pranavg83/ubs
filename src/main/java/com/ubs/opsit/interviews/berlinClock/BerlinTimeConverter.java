package com.ubs.opsit.interviews.berlinClock;

import com.ubs.opsit.interviews.berlinClock.builders.BerlinTimeBuilder;

import org.apache.commons.lang.StringUtils;

public class BerlinTimeConverter implements TimeConverter {

    private BerlinTimeBuilder berlinTimeBuilder = new BerlinTimeBuilder();

    @Override
    public String convertTime(String aTime) {
        String[] timeIntervals = StringUtils.split(aTime,':');
        String berlinTimeIndicator = berlinTimeBuilder.withHours(timeIntervals[0])
                                                      .withMinutes(timeIntervals[1])
                                                      .withSeconds(timeIntervals[2])
                                                      .build();
        return berlinTimeIndicator;
    }
}
