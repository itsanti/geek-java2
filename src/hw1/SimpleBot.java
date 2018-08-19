package hw1;

import java.util.ArrayList;

/**
 * simple command bot
 *
 * @author Aleksandr Kurov
 * @version dated Авг. 16, 2018
 */

public class SimpleBot {

    private ArrayList<ICommand> commands;

    public SimpleBot() {
        this.commands  = new ArrayList<>();
        System.out.println("SimpleBot is running now");
    }

    public void addCommand(ICommand cmd) {
        this.commands.add(cmd);
    }

    public ArrayList<ICommand> getCommands() {
        return this.commands;
    }

}
