package com.ubs.opsit.interviews.berlinClock;

import com.ubs.opsit.interviews.berlinClock.builders.BerlinTimeBuilder;

import com.ubs.opsit.interviews.berlinClock.exceptions.TimeConverterException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class BerlinTimeConverter implements TimeConverter {

    private static final Logger LOG = LoggerFactory.getLogger(BerlinTimeConverter.class);

    private BerlinTimeBuilder berlinTimeBuilder = new BerlinTimeBuilder();

    @Override
    public String convertTime(String aTime) throws TimeConverterException {
        MDC.put("id",UUID.randomUUID().toString());
        LOG.info(MessageFormat.format("Starting to convert {0} time to Berlin clock time",aTime));
        String berlinTimeIndicator;
        try {
            String[] timeIntervals = StringUtils.split(aTime, ':');
            if (timeIntervals.length != 3) {
                throw new IllegalArgumentException("Time should contain all hour:minute:seconds pieces");
            }
            berlinTimeIndicator = berlinTimeBuilder.withHours(timeIntervals[0])
                    .withMinutes(timeIntervals[1])
                    .withSeconds(timeIntervals[2])
                    .build();
            LOG.info(MessageFormat.format("Converted {0} time to Berlin clock time - {1}", aTime, berlinTimeIndicator));
        }
        catch (Exception e) {
           throw new TimeConverterException(MessageFormat.format("Exception while converting time {0} to Berlin clock time",aTime),e);
        }
        return berlinTimeIndicator;
    }
}
