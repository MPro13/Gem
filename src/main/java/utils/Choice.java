package utils;

import model.Gem;
import model.Necklace;
import service.SortService;

import java.util.List;
import java.util.Scanner;

public class Choice {

    public static void searchInList(List<Necklace> ListOfNecklace, List<Gem> ListOfGems) {
        System.out.println("Choose one of the options:\n\t1) Search in the gems' list;\n\t2) Search in one of the necklaces;");
        int d = ConsoleReader.inputNaturalNumber();
        if (d == 1) {
            SortService.SearchGems(ListOfGems);
        } else if (d == 2) {
            SortService.SearchNecklace(ListOfNecklace);
        }
    }

    public static int choiceForNotFoundNecklace() {
        System.out.println("Necklace with this name is not found in the list");
        System.out.println("Create a new one?\n1 - yes      2 - no\n");
        return ConsoleReader.inputNaturalNumber();
    }

    public static int choiceForPrintInfo() {
        System.out.println("Do you want to see info about:");
        System.out.println("1 - gems      2 - necklaces\n");
        return ConsoleReader.inputNaturalNumber();
    }

}
