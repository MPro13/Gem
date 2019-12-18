package pattern.commands;

import menu.Menu;

public class SortCommand implements Command {

    private Menu menu;

    public SortCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.sort();
    }
}
