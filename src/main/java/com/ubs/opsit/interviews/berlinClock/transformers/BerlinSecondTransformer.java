package com.ubs.opsit.interviews.berlinClock.transformers;

import com.ubs.opsit.interviews.berlinClock.enums.LampType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

import static com.ubs.opsit.interviews.berlinClock.rules.BerlinClockRules.SECONDS_EVEN_LAMP;
import static com.ubs.opsit.interviews.berlinClock.rules.BerlinClockRules.SECONDS_ODD_LAMP;

/**
 * This class transforms the minutes to Berlin Lamp Indicator
 */
public class BerlinSecondTransformer {

    private static final Logger LOG = LoggerFactory.getLogger(BerlinSecondTransformer.class);

    public String transform(String seondsInterval) {
        String secondIndicator = Math.floorMod(Integer.parseInt(seondsInterval),2) == 0
                            ? LampType.getIndicator(SECONDS_EVEN_LAMP)
                            : LampType.getIndicator(SECONDS_ODD_LAMP);
        LOG.debug(MessageFormat.format("Converted second interval {0} to Berlin clock time - {1}",seondsInterval,secondIndicator));
        return secondIndicator;
    }
}
