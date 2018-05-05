package com.ubs.opsit.interviews.berlinClock.transformers;

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
    public void testWhenSecondsIs00(){
        String expectedOutput = "Y";
        assertThat(berlinSecondTransformer.transform("00")).isEqualTo(expectedOutput);
    }

    @Test
    public void testWhenSecondsIs01(){
        String expectedOutput = "O";
        assertThat(berlinSecondTransformer.transform("01")).isEqualTo(expectedOutput);
    }

    @Test
    public void testWhenSecondsIs59(){
        String expectedOutput = "O";
        assertThat(berlinSecondTransformer.transform("59")).isEqualTo(expectedOutput);
    }

}
