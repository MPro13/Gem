package service;

import exceptions.NotFoundException;
import menu.Main;
import model.Gem;
import utils.ConsoleReader;
import utils.Info;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class GemService {

    private static Scanner fileScanner;

    public static List<Gem> inputGem(List<Gem> gemList) {
        Gem gem = new Gem();
        System.out.println("Choose one of the options:\n\t1) Input data;\n\t2) Get data from file;");
        String buff;
        int option =  ConsoleReader.inputNaturalNumber();
        if (option == 1) {
            System.out.println("Enter the name of the gem:");
            gem.setName(ConsoleReader.inputLine());
            System.out.println("Enter the gem's weight:");
            gem.setWeight( ConsoleReader.inputNaturalNumber());
            System.out.println("Enter the gem's price:");
            gem.setPrice( ConsoleReader.inputNaturalNumber());
            System.out.println("Enter the gem's transparency:");
            int transparency = ConsoleReader.inputNaturalNumber();
            gem.setTransparency( ConsoleReader.checkTransparency( transparency ) );
            gemList.add(gem);
            Main.logger.info( "Gem " + gem.getName() + " was added through the console" );
        } else if (option == 2) {
            try {
                fileScanner = new Scanner( new File( "res//1.txt" ) );
            } catch (Exception e) {
                Main.logger.error( "File with gems info wasn't found" );
                e.printStackTrace();
            }
            do {
                buff = fileScanner.next();
                Gem newGem = new Gem();
                newGem.setName( buff );
                newGem.setWeight( fileScanner.nextInt() );
                newGem.setPrice( fileScanner.nextInt() );
                newGem.setTransparency( fileScanner.nextInt() );
                gemList.add( newGem );
                Main.logger.info( "Gem " + newGem.getName() + " was added from file" );
            } while (fileScanner.hasNextLine());
            return gemList;
        } else {
            return gemList;
        }
        return gemList;
    }

    static Gem findGem(List<Gem> gemList, String name) {

        if(gemList.size() == 0){
            System.out.println("Gem list is empty");
            Main.logger.warn( "Gem list was empty" );
            inputGem(gemList);
            return gemList.get( 0 );
        }

        for (Gem value : gemList) {
            if (value.getName().equals(name)) {
                Main.logger.info( "Gem " + name + " was found" );
                return value;
            }
        }
        Main.logger.warn( "Gem " + name + " wasn't found" );
        inputGem( gemList );
        return gemList.get(gemList.size()-1);
    }

    public static List<Gem> deleteGem(List<Gem> gemList) {
        Info.printInfoAboutGems(gemList);
        System.out.println("Enter the gem's name you want to delete:");
        String name = ConsoleReader.inputLine();
        Predicate<Gem> condition = gem -> gem.getName().equals(name);
        boolean result = gemList.removeIf(condition);
        if (!result) {
            Main.logger.error( "Called NotFoundException, gem wasn't deleted" );
            throw new NotFoundException( "Gem " + name + " was not found of deleted" );
        }
        Main.logger.info( "Gem " + name + " was deleted" );
        return gemList;
    }
}
