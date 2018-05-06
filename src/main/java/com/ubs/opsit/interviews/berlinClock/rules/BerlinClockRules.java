package com.ubs.opsit.interviews.berlinClock.rules;

import com.ubs.opsit.interviews.berlinClock.enums.LampType;

public class BerlinClockRules {

    /**
     * Rules for seconds indicator
     */
    public static final LampType SECONDS_EVEN_LAMP = LampType.YELLOW;
    public static final LampType SECONDS_ODD_LAMP = LampType.OFF;

    /**
     * Rules for hour indicator
     */
    public static final int SECOND_ROW_HOUR_INTERVAL = 5;
    public static final int MAX_HOUR_BULB_COUNT = 4;
    public static final LampType HOUR_ON_LAMP = LampType.RED;
    public static final LampType HOUR_OFF_LAMP = LampType.OFF;

    /**
     * Rules for minute indicator
     */
    public static final int FOURTH_ROW_MINUTE_INTERVAL = 5;
    public static final int FOURTH_ROW_MAX_MINUTE_BULB_COUNT =11;
    public static final int FIFTH_ROW_MAX_MINUTE_BULB_COUNT=4;
    public static final LampType MINUTE_ON_LAMP = LampType.YELLOW;
    public static final LampType MINUTE_OFF_LAMP = LampType.OFF;
    public static final LampType QUARTER_ON_LAMP = LampType.RED;
    public static final String QUARTER_POSITIONS = "3,6,9";

}
