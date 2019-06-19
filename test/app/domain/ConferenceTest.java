package app.domain;

import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.*;

/**
 * Created by Marcelo on 23/03/2017.
 */
public class ConferenceTest {


    @Test
    public void getFreeSession() throws Exception {


        Session morning = new Session();
        morning.setBeginTime(LocalTime.of(9,0));
        morning.setFinishTime(LocalTime.of(12,0));



        Conference conference = new Conference();


        assertEquals(morning, conference.getFreeSession());


    }

}