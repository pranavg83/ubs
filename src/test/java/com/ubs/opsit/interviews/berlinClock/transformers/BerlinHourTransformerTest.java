package com.ubs.opsit.interviews.berlinClock.transformers;

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

    @Test
    public void testWhenHourIs13(){
        String expectedOutput = "RROO" + "\n" + "RRRO";
        assertThat(berlinHourTransformer.transform("13")).isEqualTo(expectedOutput);
    }

    @Test
    public void testWhenHourIs23(){
        String expectedOutput = "RRRR" + "\n" + "RRRO";
        assertThat(berlinHourTransformer.transform("23")).isEqualTo(expectedOutput);
    }

    @Test
    public void testWhenHourIs24(){
        String expectedOutput = "RRRR" + "\n" + "RRRR";
        assertThat(berlinHourTransformer.transform("24")).isEqualTo(expectedOutput);
    }
}
