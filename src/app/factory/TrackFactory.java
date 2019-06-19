package app.factory;

import app.domain.Session;
import app.domain.Talk;
import app.domain.Track;

import java.time.LocalTime;

/**
 * Track Factory
 *
 * @author Marcelo Martins on 23/03/2017
 */
public class TrackFactory {

    /**
     * Create a default track
     *
     * Configure it with two sessions and a lunch time between them
     */
    public static Track createTrack() {

        Track track = new Track();

        // Morning
        Session morning = new Session();
        morning.setBeginTime(LocalTime.of(9,0));
        morning.setFinishTime(LocalTime.of(12,0));
        track.addSession(morning);

        // Lunch
        Session lunch = new Session();
        lunch.setBeginTime(LocalTime.of(12,0));
        lunch.setFinishTime(LocalTime.of(13,0));
        lunch.addTalk(new Talk("Lunch", 60));
        track.addSession(lunch);

        // Afternoon
        Session afternoon = new Session();
        afternoon.setBeginTime(LocalTime.of(13,0));
        afternoon.setFinishTime(LocalTime.of(17,0));
        afternoon.setNetworkingEvent(new Talk("Networking Event"));
        afternoon.setNetworkingEventFrame(60);
        track.addSession(afternoon);

        return track;

    }


}
