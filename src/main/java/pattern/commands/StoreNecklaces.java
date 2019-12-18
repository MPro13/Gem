package pattern.commands;

import menu.Menu;

public class StoreNecklaces implements Command {
    private Menu menu;

    public StoreNecklaces(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.storeNecklace();
    }
}
