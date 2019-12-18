package menu;

import functions.Logger;

import java.util.InputMismatchException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;

public class Main {
    static boolean exit = false;
    private static Handler conH;

    public static void main(String[] args) {
        conH = new ConsoleHandler();
        Runner.logger.addHandler(conH);
        Runner.logger.setUseParentHandlers(false);
        Runner.logger.info("Start of the program.");
        Logger logger = new Logger();
        logger.CreateLogger("Start of the program.");
        Runner runner = new Runner();
        do {
            try {
                runner.opt();
            } catch (InputMismatchException e) {
                System.out.println("You've entered a bullshit!");
            }
        } while (!exit);
        logger.CreateLogger("End of the program.\n--------------------------------------------------");
        Runner.logger.info("End of the program.");
    }
}
