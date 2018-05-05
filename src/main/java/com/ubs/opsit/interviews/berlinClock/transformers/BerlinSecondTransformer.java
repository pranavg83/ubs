package com.ubs.opsit.interviews.berlinClock.transformers;

import com.ubs.opsit.interviews.berlinClock.enums.LampType;

import static com.ubs.opsit.interviews.berlinClock.rules.BerlinClockRules.SECONDS_EVEN_LAMP;
import static com.ubs.opsit.interviews.berlinClock.rules.BerlinClockRules.SECONDS_ODD_LAMP;

/**
 * This class transforms the minutes to Berlin Lamp Indicator
 */
public class BerlinSecondTransformer {

    public String transform(String seondsInterval) {
        String indicator = Math.floorMod(Integer.parseInt(seondsInterval),2) == 0
                            ? LampType.getIndicator(SECONDS_EVEN_LAMP)
                            : LampType.getIndicator(SECONDS_ODD_LAMP);
        return indicator;
    }
}
