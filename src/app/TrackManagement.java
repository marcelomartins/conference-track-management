package app;

import app.domain.Conference;
import app.domain.Session;
import app.domain.Talk;
import app.reader.InputTalksReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Conference Track Management
 *
 * @author Marcelo Martins on 23/03/2017
 */
public class TrackManagement {


    private InputTalksReader inputTalksReader;


    public TrackManagement() {
        inputTalksReader = new InputTalksReader();
    }


    public void inputData(String inputData) {
        inputTalksReader.setInputData(inputData);
    }


    /**
     * Fits the talks into the conference's tracks
     *
     * I thought of a more efficient solution, which has different results each time, taking talks randomly.
     *
     */
    public void fitProposals() {

        // process data file
        inputTalksReader.processInputTalks();

        // get talks read from file
        List<Talk> talks = inputTalksReader.getTalks();

        // create a new conference
        Conference conference = new Conference();

        Random rand = new Random();
        List<Talk> processingTalks;

        // process while have talks to fit.
        while (talks.size() > 0) {

            // create a empty list os talks
            processingTalks = new ArrayList();

            // add all talks not processed yet
            processingTalks.addAll(talks);

            // get next free session from conference
            Session session = conference.getFreeSession();

            long sessionDuration = session.getDuration();

            // array of talks to be checked if it fits in session
            List<Talk> provisionedTalks = new ArrayList<>();

            long provisionedDuration = 0;

            // randomly gets talks until the duration to be minor them session duration or ends talks to process
            while (processingTalks.size() > 0) {

                Talk talk = processingTalks.remove(rand.nextInt(processingTalks.size()));

                // if this talk overlaps session duration, stop
                if ((provisionedDuration+talk.getDuration()) > sessionDuration) {
                    break;
                }

                provisionedDuration += talk.getDuration();

                // add talks in array for later duration checking
                provisionedTalks.add(talk);

            }


            // if provisioned talks fits in session duration
            if ((provisionedDuration == sessionDuration && session.getNetworkingEventFrame() == 0)
                    || (provisionedDuration < sessionDuration && (provisionedDuration+session.getNetworkingEventFrame()) > sessionDuration)
                    || (provisionedDuration < sessionDuration && talks.size() == provisionedTalks.size())) {

                // add talks in current session
                session.addAllTalks(provisionedTalks);

                // remove from next processing
                talks.removeAll(provisionedTalks);

            }


            // just it :)
        }


        // show Tracks results
        conference.showTracks();




    }

}
