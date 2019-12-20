package service;

import exceptions.NotFoundException;
import lombok.SneakyThrows;
import menu.Main;
import model.Gem;
import model.Necklace;
import utils.ConsoleReader;
import utils.Info;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;

public class NecklaceService {

    public static List <Necklace> addGemToNecklace(List <Gem> gemList, List <Necklace> necklaceList) {
        Info.printInfoAboutNecklaces(necklaceList);
        System.out.println("Enter the necklace's name you want to add gem to:");
        String necklaceName = ConsoleReader.inputLine();
        Necklace necklace = findNecklace(necklaceList, necklaceName);
        System.out.println("Enter the gem's name you want to add to the necklace:");
        String title = ConsoleReader.inputLine();
        Gem gem = GemService.findGem(gemList, title);
        necklace.getGemList().add(gem);
        Main.logger.info( "Gem was added to the necklace " + necklaceName );
        gemList.remove(gem);
        Main.logger.info( "Gem was removed from gemlist" );
        necklace.count();
        return necklaceList;
    }

    public static Necklace findNecklace(List <Necklace> necklaceList, String name) {
        if(necklaceList.size() == 0){
            List <Necklace> necklaces = createNecklace(necklaceList, Optional.of(name));
            return necklaces.get(necklaces.size()-1);
        }
        for (Necklace necklace : necklaceList) {
            if (necklace.getName().equals(name)) {
                Main.logger.info( "Necklace " + name + " was found" );
                return necklace;
            }
        }
        createNecklace( necklaceList, Optional.of( name ) );
        return necklaceList.get(necklaceList.size() - 1);
    }

    public static List <Necklace> createNecklace(List <Necklace> necklaceList, Optional <String> name) {
        Necklace necklace = new Necklace();
        String necklaceName = name.orElse(null);
        if (necklaceName == null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input necklace name: ");
            necklaceName = ConsoleReader.inputLine();;
        }
        necklace.setName(necklaceName);
        necklaceList.add(necklace);
        Main.logger.info( "Necklace" + necklace.getName() + "was created" );
        return necklaceList;
    }

    public static List <Necklace> deleteNecklace(List <Necklace> necklaceList) {
        Info.printInfoAboutNecklaces(necklaceList);
        System.out.println("Enter the necklace's name you want to delete:");
        String name = ConsoleReader.inputLine();
        Predicate <Necklace> condition = necklace -> necklace.getName().equals(name);
        boolean result = necklaceList.removeIf(condition);
        if (!result) {
            Main.logger.error( "Necklace " + name + " wasn't deleted" );
            throw new NotFoundException( "Necklace was not found of deleted already" );
        }
        return necklaceList;
    }

    public static List <Necklace> deleteGemFromNecklace(List <Necklace> necklaceList) {
        Info.printInfoAboutNecklaces( necklaceList );
        System.out.println( "Enter the name of necklace you want to delete gem in:" );
        String name = ConsoleReader.inputLine();
        Necklace necklace = NecklaceService.findNecklace( necklaceList, name );
        Main.logger.info( "Gem will be deleted from necklace " + necklace.getName() );
        GemService.deleteGem( necklace.getGemList() );
        necklace.count();
        return necklaceList;
    }

    @SneakyThrows
    public static void storeNecklace(List <Necklace> necklaceList) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat( "dd-MM-yyyy HH-mm-ss" );
        File file = new File( "savedNecklace " + formatter.format( date ) + ".txt" );
        BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter( file, true ) );
        for (Necklace necklace : necklaceList) {
            necklace.count();
            try {
                bufferedWriter.write( necklace.toString() );
                bufferedWriter.newLine();
            } catch (IOException e) {
                Main.logger.error( "Error occurred with saving necklace into file" );
                e.printStackTrace();
            }
        }
        bufferedWriter.write( "----------------------------------------\n" );
        bufferedWriter.close();
    }
}

