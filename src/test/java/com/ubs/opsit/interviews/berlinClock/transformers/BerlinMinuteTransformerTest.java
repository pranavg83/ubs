package com.ubs.opsit.interviews.berlinClock.transformers;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BerlinMinuteTransformerTest {

    private BerlinMinuteTransformer berlinMinuteTransformer;

    @Before
    public void setUp() {
        berlinMinuteTransformer = new BerlinMinuteTransformer();
    }

    @Test
    public void testWhenHourIs00(){
        String expectedOutput = "OOOOOOOOOOO" + "\n" + "OOOO";
        assertThat(berlinMinuteTransformer.transform("00")).isEqualTo(expectedOutput);
    }

    @Test
    public void testWhenHourIs59(){
        String expectedOutput = "YYRYYRYYRYY" + "\n" + "YYYY";
        assertThat(berlinMinuteTransformer.transform("59")).isEqualTo(expectedOutput);
    }

    @Test
    public void testWhenHourIs17(){
        String expectedOutput = "YYROOOOOOOO" + "\n" + "YYOO";
        assertThat(berlinMinuteTransformer.transform("17")).isEqualTo(expectedOutput);
    }

}
