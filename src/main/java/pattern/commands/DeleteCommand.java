package pattern.commands;

import menu.Menu;

public class DeleteCommand implements Command {

    private Menu menu;

    public DeleteCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.delete();
    }
}
