package pattern;

import pattern.commands.*;

public class Invoker {
    private Command input;
    private Command delete;
    private Command sort;
    private Command addToNecklace;
    private Command deleteFromNecklace;
    private Command sortNecklace;
    private Command inpNecklace;
    private Command delNecklace;
    private Command allInformation;
    private Command selection;
    private Command print;
    private Command storeNecklaces;

    public Invoker(Command input, Command delete,
                   Command sort, Command addToNecklace,
                   Command deleteFromNecklace, Command sortNecklace,
                   Command inpNecklace, Command delNecklace,
                   Command allInformation, Command selection,
                   Command print, Command storeNecklaces) {
        this.input = input;
        this.delete = delete;
        this.sort = sort;
        this.addToNecklace = addToNecklace;
        this.deleteFromNecklace = deleteFromNecklace;
        this.sortNecklace = sortNecklace;
        this.inpNecklace = inpNecklace;
        this.delNecklace = delNecklace;
        this.allInformation = allInformation;
        this.selection = selection;
        this.print = print;
        this.storeNecklaces = storeNecklaces;
    }


    public void inputGem() {
        input.execute();
    }

    public void deleteGem() {
        delete.execute();
    }

    public void sortGem() {
        sort.execute();
    }

    public void addGemToNeck() {
        addToNecklace.execute();
    }

    public void deleteGemFromNeck() {
        deleteFromNecklace.execute();
    }

    public void sortGemInNeck() {
        sortNecklace.execute();
    }

    public void inputNecklace() {
        inpNecklace.execute();
    }

    public void deleteNecklace() {
        delNecklace.execute();
    }

    public void allInformation() {
        allInformation.execute();
    }

    public void select() {
        selection.execute();
    }

    public void print() {
        print.execute();
    }

    public void storeNecklaces() {
        storeNecklaces.execute();
    }
}
