package pattern.commands;

import menu.Menu;

public class DeleteFromNecklaceCommand implements Command {

    private Menu menu;

    public DeleteFromNecklaceCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.deleteFromNecklace();
    }
}
