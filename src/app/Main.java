package app;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Conference Track Management
 *
 * @author Marcelo Martins on 23/03/2017
 *
 */
public class Main {


    private static final Logger logger = Logger.getLogger( Main.class.getName() );

    public static void main(String[] args) {


        if (args.length < 1) {
            logger.log(Level.SEVERE, "NO INPUT FILE.");
            System.exit(1);
        }

        String inputData = args[0];

        TrackManagement app = new TrackManagement();

        app.inputData(inputData);
        app.fitProposals();




    }
}
