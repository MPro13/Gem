package utils;

import model.Gem;
import model.Necklace;
import service.SortService;

import java.util.List;
import java.util.Scanner;

public class Choice {

    private static Scanner scanner = new Scanner(System.in);

    //    public static int[] Switcher() {
//        int low, high, option;
//        System.out.println("Choose one of the options:\n\t1) Search by price;\n\t2) Search by weight;\n\t3) Search by transparency;");
//        option = scanner.nextInt();
//        System.out.println("Enter the min value:");
//        low = scanner.nextInt();
//        System.out.println("Enter the max value:");
//        high = scanner.nextInt();
//        if (low == high) {
//            System.out.println("The \"X\" value is the same as \"Y\"");
//            return null;/*&&&&&*/
//        }
//        if (low > high) {
//            int temp = low;
//            low = high;
//            high = temp;
//        }
//        int [] result = {option,low,high};
//        return result;
//    }
    public static void searchInList(List<Necklace> ListOfNecklace, List<Gem> ListOfGems) {
        System.out.println("Choose one of the options:\n\t1) Search in the gems' list;\n\t2) Search in one of the necklaces;");
        int d;
        scanner.reset();
        d = scanner.nextInt();
        if (d == 1) {
            SortService.SearchGems(ListOfGems);
        } else if (d == 2) {
            SortService.SearchNecklace(ListOfNecklace);
        }
    }

    public static int choiceForNotFoundNecklace() {
        System.out.println("Necklace with this name is not found in the list");
        System.out.println("Create a new one?\n1 - yes      2 - no\n");
        return scanner.nextInt();
    }

    public static int choiceForPrintInfo() {
        System.out.println("Do you want to see info about:");
        System.out.println("1 - gems      2 - necklaces\n");
        return scanner.nextInt();
    }
}
