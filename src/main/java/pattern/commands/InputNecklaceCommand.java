package pattern.commands;

import menu.Menu;

public class InputNecklaceCommand implements Command {

    private Menu menu;

    public InputNecklaceCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute()
    {
        menu.addNecklace();
    }
}
