package service;

import model.Gem;
import model.Necklace;
import utils.Info;

import java.util.List;
import java.util.Scanner;

public class SortService {

    private static Scanner scanner = new Scanner(System.in);

    private static int low, high, option;

    public static void SearchGems(List <Gem> gemList) {
        System.out.println("Choose one of the options:\n\t1) Search by price;\n\t2) Search by weight;\n\t3) Search by transparency;");
        choose();
        if (option == 1) {
            GemsByPrice(gemList, low, high);
        } else if (option == 2) {
            GemsByWeight(gemList, low, high);
        } else if (option == 3) {
            GemsByTransparency(gemList, low, high);
        }
    }

    public static void SearchNecklace(List <Necklace> necklaceList) {
        System.out.println("Choose one of the options:\n\t1) Search by price;\n\t2) Search by weight;\n\t");
        choose();
        if (option == 1) {
            NecklacesByPrice(necklaceList, low, high);
        } else if (option == 2) {
            NecklacesByWeight(necklaceList, low, high);
        }
    }

    private static void choose() {
        option = scanner.nextInt();
        System.out.println("Enter the min value:");
        low = scanner.nextInt();
        System.out.println("Enter the max value:");
        high = scanner.nextInt();
        if (low == high) {
            System.out.println("The \"X\" value is the same as \"Y\"");
            //return null;/*&&&&&*/
        }
        if (low > high) {
            int temp = low;
            low = high;
            high = temp;
        }
    }

    private static void GemsByPrice(List <Gem> gemList, int lowerValue, int higherValue) {
        for (Gem listOfGem : gemList) {
            if (listOfGem.getPrice() >= lowerValue && listOfGem.getPrice() <= higherValue) {
                System.out.println(listOfGem);
            }
        }
    }

    private static void GemsByWeight(List <Gem> gemList, int lowerValue, int higherValue) {
        for (Gem listOfGem : gemList) {
            if (listOfGem.getWeight() >= lowerValue && listOfGem.getWeight() <= higherValue) {
                System.out.println(listOfGem);
            }
        }
    }

    private static void GemsByTransparency(List <Gem> gemList, int lowerValue, int higherValue) {
        for (Gem listOfGem : gemList) {
            if (listOfGem.getTransparency() >= lowerValue && listOfGem.getTransparency() <= higherValue) {
                System.out.println(listOfGem);
            }
        }
    }

    private static void NecklacesByPrice(List <Necklace> necklaceList, int lowerValue, int higherValue) {
        for (Necklace necklace : necklaceList) {
            necklace.count();
            if (necklace.getPrice() >= lowerValue && necklace.getPrice() <= higherValue) {
                Info.printInfoAboutNecklace(necklace);
            }
        }
    }

    private static void NecklacesByWeight(List <Necklace> necklaceList, int lowerValue, int higherValue) {
        for (Necklace necklace : necklaceList) {
            necklace.count();
            if (necklace.getWeight() >= lowerValue && necklace.getWeight() <= higherValue) {
                System.out.println(necklace);
            }
        }
    }

    public static List <Gem> sortGems(List <Gem> gemList) {
        Gem bubble;
        for (int i = 0; i < gemList.size(); i++) {
            for (int j = 0; j < gemList.size() - 1; j++) {
                if (gemList.get(j).getPrice() > gemList.get(j + 1).getPrice()) {
                    bubble = gemList.get(j + 1);
                    gemList.set(j + 1, gemList.get(j));
                    gemList.set(j, bubble);
                }
            }
        }
        return gemList;
    }

    /*
     * Create generic for bubble sort
     * */

    public static List <Necklace> sortNecklace(List <Necklace> necklaceList) {
        //   l1.CreateLogger("Attempt to sort the gem's list.\n");
        Necklace bubble;
        for (int i = 0; i < necklaceList.size(); i++)
            for (int j = 0; j < necklaceList.size() - 1; j++) {
                necklaceList.get(j).count();/*???*/
                if (necklaceList.get(j).getPrice() > necklaceList.get(j + 1).getPrice()) {
                    bubble = necklaceList.get(j + 1);
                    necklaceList.set(j + 1, necklaceList.get(j));
                    necklaceList.set(j, bubble);
                }

            }
        return necklaceList;
    }

}
