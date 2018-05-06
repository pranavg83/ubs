package com.ubs.opsit.interviews.berlinClock.transformers;

import com.ubs.opsit.interviews.berlinClock.exceptions.TimeConverterException;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BerlinSecondTransformerTest {

    private BerlinSecondTransformer berlinSecondTransformer;

    @Before
    public void setUp() {
        berlinSecondTransformer = new BerlinSecondTransformer();
    }

    @Test
    public void testWhenSecondsIs00() throws TimeConverterException {
        String expectedOutput = "Y";
        assertThat(berlinSecondTransformer.transform("00")).isEqualTo(expectedOutput);
    }

    @Test
    public void testWhenSecondsIs01() throws TimeConverterException {
        String expectedOutput = "O";
        assertThat(berlinSecondTransformer.transform("01")).isEqualTo(expectedOutput);
    }

    @Test
    public void testWhenSecondsIs59() throws TimeConverterException {
        String expectedOutput = "O";
        assertThat(berlinSecondTransformer.transform("59")).isEqualTo(expectedOutput);
    }

    @Test(expected = TimeConverterException.class)
    public void testException() throws TimeConverterException {
        berlinSecondTransformer.transform("aa");
    }

}
