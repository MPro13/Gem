package menu;

import pattern.Invoker;
import pattern.commands.*;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Runner {
    public static final Logger logger = Logger.getLogger("Functions class");

    public static void opt() throws InputMismatchException {
        int option;
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        Invoker invoker = new Invoker(
                new InputGemCommand(menu),
                new DeleteCommand(menu),
                new SortNecklaceCommand(menu),
                new AddToNecklaceCommand(menu),
                new DeleteFromNecklaceCommand(menu),
                new SortNecklaceCommand(menu),
                new InputNecklaceCommand(menu),
                new DeleteNecklaceCommand(menu),
                new InfoAboutGemsCommand(menu),
                new InfoAboutGemsCommand(menu),
                new SelectCommand(menu),
                new StoreNecklaces(menu));
        do {
            System.out.println("Choose what to do:\n\t1) Input a gem;\n\t2) Delete a gem;" +
                    "\n\t3) Sort gems;\n\t4) Add gem to necklace;\n\t" +
                    "5) Delete gem from necklace;\n\t6) Sort gems in necklace;\n\t" +
                    "7) Input necklace;\n\t8) Delete necklace;\n\t9) Count all information about the necklace;\n\t" +
                    "10) Select gems's by the parameters;\n\t11) Print information;\n\t12) Exit;" +
                    "\n\t13) Save necklace;");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    invoker.inputGem();
                    break;
                case 2:
                    invoker.deleteGem();
                    break;
                case 3:
                    invoker.sortGem();
                    break;
                case 4:
                    invoker.addGemToNeck();
                    break;
                case 5:
                    invoker.deleteGemFromNeck();
                    break;
                case 6:
                    invoker.sortGemInNeck();
                    break;
                case 7:
                    invoker.inputNecklace();
                    break;
                case 8:
                    invoker.deleteNecklace();
                    break;
                case 9:
                    invoker.allInformation();
                    break;
                case 10:
                    invoker.select();
                    break;
                case 11:
                    invoker.print();
                    break;
                case 13:
                    invoker.storeNecklaces();
                default:
                    Main.exit = true;
                    return;
            }
        } while (true);

    }
}
