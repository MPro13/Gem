package pattern.commands;

import menu.Menu;

public class SelectCommand implements Command {

    private Menu menu;

    public SelectCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.selection();
    }
}
