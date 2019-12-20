package pattern.commands;

import menu.Menu;

public class InputGemCommand implements Command {

    private Menu menu;

    public InputGemCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.inputGem();
    }
}
