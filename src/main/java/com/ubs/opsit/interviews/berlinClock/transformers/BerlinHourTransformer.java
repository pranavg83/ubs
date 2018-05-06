package com.ubs.opsit.interviews.berlinClock.transformers;

import com.ubs.opsit.interviews.berlinClock.BerlinTimeConverter;
import com.ubs.opsit.interviews.berlinClock.enums.LampType;
import com.ubs.opsit.interviews.berlinClock.exceptions.TimeConverterException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

import static com.ubs.opsit.interviews.berlinClock.rules.BerlinClockRules.*;

/**
 * This class transforms hours in HH (24 hour format) to Berlin Lamp Indicator for hours
 */
public class BerlinHourTransformer {

    private static final Logger LOG = LoggerFactory.getLogger(BerlinHourTransformer.class);

     /**
     *
     * @param hourInterval - HH (24 hour format)
     * @return Berlin Lamp Indicator for hours
     */
    public String transform(String hourInterval) throws TimeConverterException {
        String hourIndicator;
        try {
            String secondRow = generateIndicator(HOUR_ON_LAMP, Math.floorDiv(Integer.parseInt(hourInterval), SECOND_ROW_HOUR_INTERVAL));
            String thirdRow = generateIndicator(HOUR_ON_LAMP, Math.floorMod(Integer.parseInt(hourInterval), SECOND_ROW_HOUR_INTERVAL));
            hourIndicator = secondRow + System.lineSeparator() + thirdRow;
            LOG.debug(MessageFormat.format("Converted hour interval {0} to Berlin clock time - {1}", hourInterval, hourIndicator));
        }
        catch (Exception e){
            throw new TimeConverterException(MessageFormat.format("Exception while converting hours {0} to Berlin clock time",hourInterval),e);
        }
        return hourIndicator;
    }

    private String generateIndicator(LampType lampType, int bulbCount) {
        String hourIndicatorSeries = lampType.getIndicatorSeries(bulbCount);
        hourIndicatorSeries = StringUtils.rightPad(hourIndicatorSeries, MAX_HOUR_BULB_COUNT, LampType.getIndicator(HOUR_OFF_LAMP));
        return hourIndicatorSeries;
    }
}
