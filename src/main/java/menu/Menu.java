package menu;

import model.Gem;
import model.Necklace;
import service.GemService;
import service.NecklaceService;
import service.SortService;
import utils.Choice;
import utils.Info;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Menu {

    private static List <Gem> gemList = new ArrayList <>();
    private static List <Necklace> necklaceList = new ArrayList <>();

    public void inputGem() {
        GemService.inputGem(gemList);
    }

    public void addNecklace() {
        NecklaceService.createNecklace(necklaceList, Optional.empty());
    }

    public void addGemToNecklace() {
        NecklaceService.addGemToNecklace(gemList,necklaceList);
    }

    public void delete() {
        GemService.deleteGem(gemList);
    }

    public void deleteNecklace() {
        NecklaceService.deleteNecklace(necklaceList);
    }

    public void deleteFromNecklace() {
        NecklaceService.deleteGemFromNecklace( necklaceList );
    }

    public void infoAboutGems() {
        Info.printInfoAboutGems( gemList );
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
        SortService.sortNecklace( necklaceList );
    }

    public void storeNecklace() {
        NecklaceService.storeNecklace( necklaceList );
    }
}
