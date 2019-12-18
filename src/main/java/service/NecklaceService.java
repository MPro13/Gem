package service;

import exceptions.NotFoundException;
import model.Gem;
import model.Necklace;
import utils.Choice;
import utils.Info;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;

public class NecklaceService {
    private static Scanner scanner = new Scanner(System.in);

    public static List <Necklace> addGemToNecklace(List <Gem> gemList, List <Necklace> necklaceList) {
        Info.printInfoAboutNecklaces(necklaceList);
        System.out.println("Enter the necklace's name you want to add gem to:");
        String necklaceName = scanner.nextLine();
        Necklace necklace = findNecklace(necklaceList, necklaceName);
        System.out.println("Enter the gem's name you want to add to the necklace:");
        String title = scanner.nextLine();
        Gem gem = GemService.findGem(gemList, title);
        necklace.getGemList().add(gem);
        gemList.remove(gem);
        return necklaceList;
    }

    public static Necklace findNecklace(List <Necklace> necklaceList, String name) {
        if(necklaceList.size() == 0){
            List <Necklace> necklaces = createNecklace(necklaceList, Optional.of(name));
            return necklaces.get(necklaces.size()-1);
        }
        for (Necklace necklace : necklaceList) {
            if (necklace.getName().equals(name)) {
                return necklace;
            } else {
                if (Choice.choiceForNotFoundNecklace() == 1) {
                    createNecklace(necklaceList, Optional.of(name));
                }
                /*loger*/
             //   throw new NotFoundException("Necklace not found");
            }
        }
    //    createNecklace(necklaceList, Optional.of(name));
    //    Necklace newNecklace = necklaceList.get(necklaceList.size() - 1);
        return necklaceList.get(necklaceList.size() - 1);
    }

    public static List <Necklace> createNecklace(List <Necklace> necklaceList, Optional <String> name) {
        Necklace necklace = new Necklace();
        String necklaceName = name.orElse(null);
        if (necklaceName == null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input necklace name: ");
            necklace.setName(scanner.next());
        }
        necklace.setName(necklaceName);
        necklaceList.add(necklace);
        return necklaceList;
    }

    public static List <Necklace> deleteNecklace(List <Necklace> necklaceList) {
        Info.printInfoAboutNecklaces(necklaceList);/**/
        System.out.println("Enter the necklace's name you want to delete:");
        String name = scanner.next();
        Predicate <Necklace> condition = necklace -> necklace.getName().equals(name);
        boolean result = necklaceList.removeIf(condition);
        if (!result) {
        /*
        * loger
        * */    throw new NotFoundException("Necklace was not found of deleted already");
        }
        return necklaceList;
    }

}

