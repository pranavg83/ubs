package com.ubs.opsit.interviews.berlinClock;

import com.ubs.opsit.interviews.berlinClock.exceptions.TimeConverterException;
import com.ubs.opsit.interviews.berlinClock.support.BehaviouralTestEmbedder;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Acceptance test class that uses the JBehave (Gerkin) syntax for writing stories.  You should not need to
 * edit this class to complete the exercise, this is your definition of done.
 */
public class BerlinClockFixture {

    private TimeConverter berlinClock = new BerlinTimeConverter();
    private String theTime;

    @Test
    public void berlinClockAcceptanceTests() throws Exception {
        BehaviouralTestEmbedder.aBehaviouralTestRunner()
                .usingStepsFrom(this)
                .withStory("berlin-clock.story")
                .run();
    }

    @When("the time is $time")
    public void whenTheTimeIs(String time) {
        theTime = time;
    }

    @Then("the clock should look like $")
    public void thenTheClockShouldLookLike(String theExpectedBerlinClockOutput) throws TimeConverterException {
        assertThat(berlinClock.convertTime(theTime)).isEqualTo(theExpectedBerlinClockOutput);
    }
}
