package pattern.commands;

import menu.Menu;

public class InfoAboutNecklaceCommand implements Command {

    private Menu menu;

    public InfoAboutNecklaceCommand(Menu menu) { this.menu = menu; }

    @Override
    public void execute() {
        menu.infoAboutNecklace();
    }
}
