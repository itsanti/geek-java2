package hw1;

/**
 * Homework #1
 *
 * @author Aleksandr Kurov
 * @version dated Август 16, 2018
 */
public class Runner {
    public static void main(String[] args) {

        SimpleBot sbot = new SimpleBot();
        sbot.addCommand(new LocalCommand("say", "hi"));
        sbot.addCommand(new LocalCommand("isint", "2"));

        for (ICommand cmd : sbot.getCommands()) {
            cmd.run();
        }

    }
}
