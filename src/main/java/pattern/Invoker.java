package pattern;

import pattern.commands.*;

public class Invoker {

    private Command input;
    private Command addNecklace;
    private Command addToNecklace;
    private Command delete;
    private Command deleteNecklace;
    private Command deleteFromNecklace;
    private Command sort;
    private Command sortNecklace;
    private Command selection;
    private Command infoAboutGems;
    private Command infoAboutNecklace;
    private Command storeNecklaces;

    public Invoker(Command input, Command addNecklace,
                   Command addToNecklace, Command delete,
                   Command deleteNecklace, Command deleteFromNecklace,
                   Command sort, Command sortNecklace,
                   Command selection, Command infoAboutGems,
                   Command infoAboutNecklace, Command storeNecklaces) {
        this.input = input;
        this.addNecklace = addNecklace;
        this.addToNecklace = addToNecklace;
        this.delete = delete;
        this.deleteNecklace = deleteNecklace;
        this.deleteFromNecklace = deleteFromNecklace;
        this.sort = sort;
        this.sortNecklace = sortNecklace;
        this.selection = selection;
        this.infoAboutGems = infoAboutGems;
        this.infoAboutNecklace = infoAboutNecklace;
        this.storeNecklaces = storeNecklaces;
    }

    public void inputGem() {
        input.execute();
    }

    public void deleteGem() {
        delete.execute();
    }

    public void deleteNecklace() {
        deleteNecklace.execute();
    }

    public void addGemToNecklace() {
        addToNecklace.execute();
    }

    public void deleteGemFromNecklace() {
        deleteFromNecklace.execute();
    }

    public void addNecklace() {
        addNecklace.execute();
    }

    public void select() {
        selection.execute();
    }

    public void sortGem() {
        sort.execute();
    }

    public void sortNecklace() {
        sortNecklace.execute();
    }

    public void storeNecklaces() {
        storeNecklaces.execute();
    }

    public void infoAboutGems() {
        infoAboutGems.execute();
    }

    public void infoAboutNecklace() {
        infoAboutNecklace.execute();
    }
}
