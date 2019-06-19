package app.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Track Object
 *
 * @author Marcelo Martins on 23/03/2017
 */
public class Track {

    private List<Session> sessions = new ArrayList();

    private int currentFreeSession = 0;

    public void addSession(Session session) {
        sessions.add(session);
    }


    /**
     * Check if the track is full
     *
     * @return
     */
    public boolean isFull() {

        Session session = this.sessions.get(this.currentFreeSession);

        // if the current session is full, check next session
        if (session.isFull()) {

            while (this.currentFreeSession < this.sessions.size()) {

                // if there is a session that is not full
                if (!this.sessions.get(this.currentFreeSession).isFull()) {
                    return false;
                }

                currentFreeSession++;

            }

            // all sessions are full
            return true;
        }

        // the current session are not full
        return false;

    }



    public Session getFreeSession() {
        return sessions.get(currentFreeSession);
    }

    public List<Session> getSessions() {
        return sessions;
    }
}
