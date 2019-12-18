package service;

import exceptions.EmptyListException;
import exceptions.NotFoundException;
import model.Gem;
import model.Necklace;
import utils.Info;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class GemService {
    private static Scanner scanner = new Scanner(System.in);

    public static void storeNecklace(List<Necklace> necklaceList){

        OutputStream ops = null;
        ObjectOutputStream objOps = null;
        Necklace necklace = necklaceList.get(0);
        try {
            ops = new FileOutputStream("Necklace.txt");
            objOps = new ObjectOutputStream(ops);
            objOps.writeObject(necklace);
            objOps.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try{
                if(objOps != null) objOps.close();
            } catch (Exception ex){

            }
        }
    }

    public static List<Gem> inputGem(List<Gem> gemList) {
        Gem gem = new Gem();
        System.out.println("Choose one of the options:\n\t1) Input data;\n\t2) Get data from file;");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        /*
         * add input from file
         * */
        if (option == 1) {
            System.out.println("Enter the name of the gem:");
            gem.setName(scanner.next());
            System.out.println("Enter the gem's weight:");
            gem.setWeight(scanner.nextInt());
            System.out.println("Enter the gem's price:");
            gem.setPrice(scanner.nextInt());
            System.out.println("Enter the gem's transparency:");
            gem.setTransparency(scanner.nextInt());
            gemList.add(gem);
        }
        return gemList;
    }

//    public static List<Gem> inputGemToNecklace(Necklace necklace) {
////        System.out.println("Enter the name of necklace you want to input gem in:");
////        String name = scanner.nextLine();
////        Necklace necklace = NecklaceService.findNecklace(necklaceList, name);
//        List <Gem> gemList = GemService.inputGem(necklace.getGemList());
//        necklace.getGemList().add(gemList.get(gemList.size()-1));/*???*/
//        return gemList;
//    }

    static Gem findGem(List<Gem> gemList, String name) {
        if(gemList.size() == 0){
            System.out.println("Gem list is empty");
            inputGem(gemList);
      /**/     // throw new EmptyListException("Gem list is empty");
        }

        for (Gem value : gemList) {
            if (value.getName().equals(name)) {
                return value;
            }else inputGem(gemList);
        }

        return gemList.get(gemList.size()-1);
    }

    public static List<Gem> deleteGem(List<Gem> gemList) {
        Info.printInfoAboutGems(gemList);
        System.out.println("Enter the gem's name you want to delete:");
        String name = scanner.next();
        Predicate<Gem> condition = gem -> gem.getName().equals(name);
        boolean result = gemList.removeIf(condition);
        if (!result) {
            throw new NotFoundException("Gem was not found of deleted");
        }
        return gemList;
    }

    public static List<Necklace> deleteGemFromNecklace(List<Necklace> necklaceList) {
        System.out.println("Enter the name of necklace you want to delete gem in:");
        String name = scanner.nextLine();
        Necklace necklace = NecklaceService.findNecklace(necklaceList, name);
      //  boolean result;
        deleteGem(necklace.getGemList());
        return necklaceList;
    }

}


