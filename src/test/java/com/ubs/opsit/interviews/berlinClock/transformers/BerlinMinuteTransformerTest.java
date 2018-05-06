package com.ubs.opsit.interviews.berlinClock.transformers;

import com.ubs.opsit.interviews.berlinClock.exceptions.TimeConverterException;
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
    public void testWhenMinuteIs00() throws TimeConverterException {
        String expectedOutput = "OOOOOOOOOOO" + System.lineSeparator() + "OOOO";
        assertThat(berlinMinuteTransformer.transform("00")).isEqualTo(expectedOutput);
    }

    @Test
    public void testWhenMinuteIs59() throws TimeConverterException {
        String expectedOutput = "YYRYYRYYRYY" + System.lineSeparator() + "YYYY";
        assertThat(berlinMinuteTransformer.transform("59")).isEqualTo(expectedOutput);
    }

    @Test
    public void testWhenMinuteIs17() throws TimeConverterException {
        String expectedOutput = "YYROOOOOOOO" + System.lineSeparator() + "YYOO";
        assertThat(berlinMinuteTransformer.transform("17")).isEqualTo(expectedOutput);
    }

}
