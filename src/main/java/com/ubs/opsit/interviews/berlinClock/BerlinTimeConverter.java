package com.ubs.opsit.interviews.berlinClock;

import com.ubs.opsit.interviews.berlinClock.builders.BerlinTimeBuilder;

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
    public String convertTime(String aTime) {
        MDC.put("id",UUID.randomUUID().toString());
        LOG.info(MessageFormat.format("Starting to convert {0} time to Berlin clock time",aTime));
        String[] timeIntervals = StringUtils.split(aTime,':');
        String berlinTimeIndicator = berlinTimeBuilder.withHours(timeIntervals[0])
                                                      .withMinutes(timeIntervals[1])
                                                      .withSeconds(timeIntervals[2])
                                                      .build();
        LOG.info(MessageFormat.format("Converted {0} time to Berlin clock time - {1}",aTime,berlinTimeIndicator));
        return berlinTimeIndicator;
    }
}
