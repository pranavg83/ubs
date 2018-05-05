package com.ubs.opsit.interviews.transformers;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BerlinHourTransformerTest {

    private BerlinHourTransformer berlinHourTransformer;

    @Before
    public void setUp() {
        berlinHourTransformer = new BerlinHourTransformer();
    }

    @Test
    public void testWhenHourIs00(){
        String expectedOutput = "OOOO" + "\n" + "OOOO";
        assertThat(berlinHourTransformer.transform("00")).isEqualTo(expectedOutput);
    }
}
