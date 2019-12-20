package pattern.commands;

import menu.Menu;

public class DeleteNecklaceCommand implements Command {

    private Menu menu;

    public DeleteNecklaceCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.deleteNecklace();
    }
}
