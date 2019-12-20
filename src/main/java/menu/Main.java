package menu;

import org.apache.log4j.Logger;

import java.util.InputMismatchException;

public class Main {
    static boolean exit = false;
    public static final Logger logger = Logger.getLogger( "GLOBAL" );

    public static void main(String[] args) {
        logger.info( "Program started." );

        do {
            try {
                Runner.option();
            } catch (InputMismatchException e) {
                System.out.println( "Incorrect input. Try again!" );
                logger.warn( "Incorrect input." );
            }
        } while (!exit);
        logger.info( "Program finished.\n--------------------------------------------------" );
    }
}
