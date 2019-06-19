package app.domain;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Session Object
 *
 * @author Marcelo Martins on 23/03/2017
 */
public class Session {

    private LocalTime beginTime;
    private LocalTime finishTime;
    private LocalTime nextFreeTime;
    private Integer networkingEventFrame = 0;

    private Talk networkingEvent;

    // talks of the session
    private List<Talk> talks = new ArrayList<>();


    /**
     * add a list of talks to the session
     *
     * when add a list of talks, ends the session free time
     *
     * @param talks list of talks
     */
    public void addAllTalks(List<Talk> talks) {

        talks.forEach((talk) ->
                this.addTalk(talk)
        );

        // end free time
        this.nextFreeTime = this.finishTime;


    }

    /**
     * add a talk to the session
     *
     * @param talk
     */
    public void addTalk(Talk talk) {

        // the index indicate where the talk must be added in the array, usually in the last element
        int index = talks.size();


        // if the session has network event the talk must be added before it
        if (this.networkingEvent != null) {

            index--;

            // if the session have no talks yet, add networking event
            if (talks.isEmpty()) {
                talks.add(this.networkingEvent);
                index = 0;
            }

        }

        // sets the time of the talk to the next free time
        talk.setTime(nextFreeTime);

        talks.add(index, talk);

        // sets the new next free time
        nextFreeTime = nextFreeTime.plusMinutes(talk.getDuration());

        // if the session has network event, shift its time to the end
        if (this.networkingEvent != null) {
            this.networkingEvent.setTime(this.nextFreeTime);
        }

    }

    public void setBeginTime(LocalTime time) {
        beginTime = time;
        nextFreeTime = time;
    }

    public void setFinishTime(LocalTime time) {
        finishTime = time;
    }


    public void setNetworkingEvent(Talk networkingEvent) {
        this.networkingEvent = networkingEvent;
    }

    public Integer getNetworkingEventFrame() {
        return networkingEventFrame;
    }


    public void setNetworkingEventFrame(Integer networkingEventFrame) {
        this.networkingEventFrame = networkingEventFrame;
    }


    public long getDuration() {
        return Duration.between(beginTime, finishTime).toMinutes();
    }

    public boolean isFull() {
        return finishTime.equals(nextFreeTime);
    }

    public List<Talk> getTalks() {
        return talks;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        final Session other = (Session) obj;

        return (this.beginTime.equals(other.beginTime) &&  this.finishTime.equals(other.finishTime) && this.networkingEventFrame == other.networkingEventFrame);

    }

}
