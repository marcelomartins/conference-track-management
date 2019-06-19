package app.reader;

import app.domain.Talk;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Marcelo on 23/03/2017.
 */
public class InputTalksReaderTest {


    @Test
    public void getTalks() throws Exception {

        InputTalksReader inputTalksReader = new InputTalksReader();

        File resourcesDirectory = new File("test/resources");

        inputTalksReader.setInputData(resourcesDirectory.getAbsolutePath()+"/input.txt");

        // process data file
        inputTalksReader.processInputTalks();

        // get talks read from file
        List<Talk> talks = inputTalksReader.getTalks();

        assertEquals(19, talks.size());


    }

}