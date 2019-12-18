package utils;

import model.Gem;
import model.Necklace;

import java.util.List;

public class Info {

    public static void printInfoAboutNecklaces(List <Necklace> necklaceList) {
        System.out.println("All necklaces from the list");
        for (Necklace necklace : necklaceList) {
            printInfoAboutNecklace(necklace);
//            printInfoAboutGems(necklace.getGemList());
        }
    }

    public static void printInfoAboutNecklace(Necklace necklace) {
        System.out.println(necklace.getName());
        System.out.println(necklace.getGemList().size());
        System.out.println(necklace.getPrice());
        System.out.println(necklace.getWeight());
//            printInfoAboutGems(necklace.getGemList());

    }

    public static void printInfoAboutGems(List <Gem> gemList) {
        System.out.println("All gems from the list");
        System.out.println(gemList);
//        for (Gem gem : gemList)
//            System.out.println(gem);
    }

}
