package pattern.commands;

import menu.Menu;

public class AddToNecklaceCommand implements Command {

    private Menu menu;

    public AddToNecklaceCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.addGemToNecklace();
    }
}
