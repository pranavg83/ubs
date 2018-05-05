package com.ubs.opsit.interviews.berlinClock.transformers;

import com.ubs.opsit.interviews.berlinClock.enums.LampType;
import org.apache.commons.lang.StringUtils;

import static com.ubs.opsit.interviews.berlinClock.rules.BerlinClockRules.*;

/**
 * This class transforms hours in HH (24 hour format) to Berlin Lamp Indicator for hours
 */
public class BerlinHourTransformer {


     /**
     *
     * @param hourInterval - HH (24 hour format)
     * @return Berlin Lamp Indicator for hours
     */
    public String transform(String hourInterval) {
        String secondRow = generateIndicator(HOUR_ON_LAMP,Math.floorDiv(Integer.parseInt(hourInterval), SECOND_ROW_HOUR_INTERVAL));
        String thirdRow = generateIndicator(HOUR_ON_LAMP,Math.floorMod(Integer.parseInt(hourInterval), SECOND_ROW_HOUR_INTERVAL));
        return secondRow + "\n" + thirdRow;
    }

    private String generateIndicator(LampType lampType, int bulbCount) {
        String hourIndicatorSeries = lampType.getIndicatorSeries(bulbCount);
        hourIndicatorSeries = StringUtils.rightPad(hourIndicatorSeries, MAX_HOUR_BULB_COUNT, LampType.getIndicator(HOUR_OFF_LAMP));
        return hourIndicatorSeries;
    }
}
