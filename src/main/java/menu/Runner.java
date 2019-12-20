package menu;

import pattern.Invoker;
import pattern.commands.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {
//    public static final Logger logger = Logger.getLogger("Functions class");

    public static void option() throws InputMismatchException {
        int option;
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        Invoker invoker = new Invoker(
                new InputGemCommand(menu),
                new InputNecklaceCommand( menu ),
                new AddToNecklaceCommand(menu),
                new DeleteCommand( menu ),
                new DeleteNecklaceCommand( menu ),
                new DeleteFromNecklaceCommand(menu),
                new SortCommand( menu ),
                new SortNecklaceCommand(menu),
                new SelectCommand( menu ),
                new InfoAboutGemsCommand(menu),
                new InfoAboutNecklaceCommand( menu ),
                new StoreNecklaces(menu));
        do {
            System.out.println( "_-_-_-_-_Choose what to do_-_-_-_-_\n\t\t" +
                    "1) Input a gem;\n\t\t2) Input a necklace;\n\t\t" +
                    "3) Add gem to necklace;\n\t\t4) Delete gem;\n\t\t" +
                    "5) Delete necklace;\n\t\t6) Delete gem from necklace;\n\t\t" +
                    "7) Info about gems;\n\t\t8) Info about necklace;\n\t\t" +
                    "9) Select gems's by the parameters;\n\t\t10) Sort gems;\n\t\t" +
                    "11) Sort necklaces;\n\t\t12) Save necklace;\n\t\t13) Exit;" );
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    invoker.inputGem();
                    break;
                case 2:
                    invoker.addNecklace();
                    break;
                case 3:
                    invoker.addGemToNecklace();
                    break;
                case 4:
                    invoker.deleteGem();
                    break;
                case 5:
                    invoker.deleteNecklace();
                    break;
                case 6:
                    invoker.deleteGemFromNecklace();
                    break;
                case 7:
                    invoker.infoAboutGems();
                    break;
                case 8:
                    invoker.infoAboutNecklace();
                    break;
                case 9:
                    invoker.select();
                    break;
                case 10:
                    invoker.sortGem();
                    break;
                case 11:
                    invoker.sortNecklace();
                    break;
                case 12:
                    invoker.storeNecklaces();
                    break;
                default:
                    Main.exit = true;
                    return;
            }
        } while (true);

    }
}
