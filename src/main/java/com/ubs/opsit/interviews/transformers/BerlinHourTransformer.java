package com.ubs.opsit.interviews.transformers;

import com.ubs.opsit.interviews.enums.LampType;
import org.apache.commons.lang.StringUtils;

import static com.ubs.opsit.interviews.enums.LampType.OFF;
import static com.ubs.opsit.interviews.enums.LampType.RED;

public class BerlinHourTransformer {


    public String transform(String hourInterval) {
        String secondRow = generateLamps(RED,Math.floorDiv(Integer.parseInt(hourInterval),5));
        String thirdRow = generateLamps(RED,Math.floorMod(Integer.parseInt(hourInterval),5));
        return secondRow + "\n" + thirdRow;
    }

    private String generateLamps(LampType lampType, int hourSlots) {
        String hourSlotIndicatorSeries = lampType.getIndicatorSeries(hourSlots);
        hourSlotIndicatorSeries = StringUtils.rightPad(hourSlotIndicatorSeries, 4, LampType.getIndicator(OFF));
        return hourSlotIndicatorSeries;
    }
}
