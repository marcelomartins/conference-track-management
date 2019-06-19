package app.domain;

import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.*;

/**
 * Created by Marcelo on 23/03/2017.
 */
public class TrackTest {


    @Test
    public void isFullFalse() throws Exception {

        Track track = new Track();

        Session session1 = new Session();
        session1.setBeginTime(LocalTime.of(10,0));
        session1.setFinishTime(LocalTime.of(12,0));
        session1.addTalk(new Talk("Talk 1", 60));
        track.addSession(session1);

        assertFalse(track.isFull());

    }



    @Test
    public void isFullTrue() throws Exception {



        Track track = new Track();

        Session session1 = new Session();
        session1.setBeginTime(LocalTime.of(10,0));
        session1.setFinishTime(LocalTime.of(11,0));
        session1.addTalk(new Talk("Talk 1", 60));
        track.addSession(session1);

        assertTrue(track.isFull());





    }


}