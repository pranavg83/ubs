package com.ubs.opsit.interviews.berlinClock.transformers;

import com.ubs.opsit.interviews.berlinClock.enums.LampType;
import org.apache.commons.lang.StringUtils;

import static com.ubs.opsit.interviews.berlinClock.rules.BerlinClockRules.*;

/**
 * This class transforms the minutes to Berlin Lamp Indicator
 */
public class BerlinMinuteTransformer {


    public String transform(String minuteInterval) {
        String fourthRow = generateIndicator(MINUTE_ON_LAMP,Math.floorDiv(Integer.parseInt(minuteInterval),FOURTH_ROW_MINUTE_INTERVAL),FOURTH_ROW_MAX_MINUTE_BULB_COUNT);
        fourthRow = replaceQuarterLamps(fourthRow);
        String fifthRow = generateIndicator(MINUTE_ON_LAMP,Math.floorMod(Integer.parseInt(minuteInterval),FOURTH_ROW_MINUTE_INTERVAL),FIFTH_ROW_MAX_MINUTE_BULB_COUNT);
        return fourthRow + System.lineSeparator() + fifthRow;
    }

    private String replaceQuarterLamps(String fourthRow) {
        char[] fourthRowBulbs = fourthRow.toCharArray();
        String[] quarterPositions = StringUtils.split(QUARTER_POSITIONS,',');
        for (String quarterPosition : quarterPositions){
            String bulbStatus = String.valueOf(fourthRowBulbs[Integer.parseInt(quarterPosition)-1]);
            if (StringUtils.equals(bulbStatus,LampType.getIndicator(MINUTE_ON_LAMP))) {
                fourthRowBulbs[Integer.parseInt(quarterPosition)-1] = LampType.getIndicator(QUARTER_ON_LAMP).charAt(0);
            }
        }
       return String.valueOf(fourthRowBulbs);
    }

    private String generateIndicator(LampType lampType, int bulbCount, int maxBulbCount) {
        String minuteIndicatorSeries = lampType.getIndicatorSeries(bulbCount);
        minuteIndicatorSeries = StringUtils.rightPad(minuteIndicatorSeries, maxBulbCount, LampType.getIndicator(MINUTE_OFF_LAMP));
        return minuteIndicatorSeries;
    }
}
