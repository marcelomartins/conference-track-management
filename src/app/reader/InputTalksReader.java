package app.reader;

import app.domain.Talk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Read Input Data File
 *
 * @author Marcelo Martins on 23/03/2017
 */
public class InputTalksReader {


    private String inputData;
    private List<String> inputTalks = new ArrayList();
    private List<Talk> talks = new ArrayList();


    private static final Logger logger = Logger.getLogger( InputTalksReader.class.getName() );


    /**
     * Read input data file and convert to talk object
     */
    public void processInputTalks() {

        // process data file
        this.readFile();

        for(String inputTalk: inputTalks) {


            // last word from talk line
            String time = inputTalk.substring(inputTalk.lastIndexOf(" ")).trim();

            if (time.equals("lightning")) {
                time = "5";
            }

            // create a talk object
            this.talks.add(new Talk(inputTalk, Integer.valueOf(Integer.parseInt(time.replaceAll("[^0-9]", "")))));


        }


    }

    /**
     * read data file
     */
    private void readFile() {

        try (BufferedReader br = Files.newBufferedReader(Paths.get(inputData))) {

            this.inputTalks = br.lines().collect(Collectors.toList());

        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            e.printStackTrace();
        }


    }

    public void setInputData(String inputData) {
        this.inputData = inputData;
    }

    public List<Talk> getTalks() {
        return this.talks;
    }
}
