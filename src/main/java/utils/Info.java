package utils;

import model.Gem;
import model.Necklace;

import java.util.List;

public class Info {

    public static void printInfoAboutNecklaces(List <Necklace> necklaceList) {
        System.out.println( "***All necklaces from the list***" );
        for (Necklace necklace : necklaceList) {
            necklace.count();
            printInfoAboutNecklace(necklace);
        }
    }

    public static void printInfoAboutNecklace(Necklace necklace) {
        System.out.println( "__________________________" );
        System.out.println( "name : " + necklace.getName() );
        System.out.println( "size : " + necklace.getGemList().size() );
        System.out.println( "price : " + necklace.getPrice() );
        System.out.println( "weight : " + necklace.getWeight() );
        System.out.println( "__________________________" );
    }

    public static void printInfoAboutGems(List <Gem> gemList) {
        System.out.println( "***All gems from the list***" );
        for (Gem gem : gemList) {
            System.out.println( "__________________________" );
            System.out.println( "name : " + gem.getName() );
            System.out.println( "weight : " + gem.getWeight() );
            System.out.println( "price : " + gem.getPrice() );
            System.out.println( "transparency : " + gem.getTransparency() );
            System.out.println( "__________________________" );
        }
    }

}
