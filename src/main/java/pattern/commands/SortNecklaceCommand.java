package pattern.commands;

import menu.Menu;

public class SortNecklaceCommand implements Command {

    private Menu menu;

    public SortNecklaceCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.sortNecklace();
    }
}
