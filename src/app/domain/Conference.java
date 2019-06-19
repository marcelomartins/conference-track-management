package app.domain;

import app.factory.TrackFactory;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Conference Object
 *
 * @author Marcelo Martins on 23/03/2017
 */
public class Conference {


    // Conference's tracks. This list have dynamic size, and start with zero tracks
    private List<Track> tracks = new ArrayList();




    /*
     * Return the next session of the track with free time for new talks
     * if the last track is full, create a new track.
     */
    public Session getFreeSession() {

        Track track;

        if (this.tracks.size() == 0 || this.tracks.get(this.tracks.size()-1).isFull()) {
            track = TrackFactory.createTrack();
            this.tracks.add(track);
        } else {
            track = this.tracks.get(this.tracks.size()-1);
        }

        return track.getFreeSession();

    }


    /*
     * List tracks
     */
    public void showTracks() {

        int trackId = 0;

        for (Track track: this.tracks) {

            trackId++;

            System.out.println("\nTrack "+trackId+":");

            track.getSessions().forEach((session) -> {

                session.getTalks().forEach((talk) -> {

                    System.out.println(talk.getTime().format(DateTimeFormatter.ofPattern("hh:mma"))+" "+talk.getName());

                });

            });

        }

    }

}
