package pattern.commands;

import menu.Menu;

public class InfoAboutGemsCommand implements Command {

    private Menu menu;

    public InfoAboutGemsCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.infoAboutGems();
    }
}
