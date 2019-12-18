package menu;

import model.Gem;
import model.Necklace;
import service.GemService;
import service.NecklaceService;
import service.SortService;
import utils.Choice;
import utils.Info;

import javax.swing.*;
import java.io.IOException;
import java.util.*;

public class Menu {

    private static List <Gem> gemList = new ArrayList <>();
    private static List <Necklace> necklaceList = new ArrayList <Necklace>();

    public void input() {
        GemService.inputGem(gemList);
    }

    public void infoAboutGems() {
        Info.printInfoAboutGems(gemList);
    }

    public void inpNeck() {
        NecklaceService.createNecklace(necklaceList, Optional.empty());
    }

    public void addToNecklace() {
        //GemService.inputGemToNecklace(necklaceList);
        NecklaceService.addGemToNecklace(gemList,necklaceList);
    }

    public void delete() {
        GemService.deleteGem(gemList);
    }

    public void delNeck() {
        NecklaceService.deleteNecklace(necklaceList);
    }

    public void deleteFromNecklace() {
        GemService.deleteGemFromNecklace(necklaceList);
    }

    public void infoAboutNecklace() {
        Info.printInfoAboutNecklaces(necklaceList);
    }

    public void selection() {
        Choice.searchInList(necklaceList, gemList);
    }

    public void sort() {
        SortService.sortGems(gemList);
    }

    public void sortNecklace() {
        SortService.SearchNecklace(necklaceList);
    }


    /**/
    public void Print() {
        Info.printInfoAboutNecklaces(necklaceList);
    }

    public void storeNecklace() {
        GemService.storeNecklace(necklaceList);
    }

    /*create custom exceptions*/
}
