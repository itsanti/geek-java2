package hw1;

/**
 * commands without network
 *
 * @author Aleksandr Kurov
 * @version dated Авг. 16, 2018
 */
public class LocalCommand extends Command implements ICommand{

    public LocalCommand(String name, String argument) {
        super(name, argument);
    }

    @Override
    public void run() {

        System.out.println(this);

        switch (this.name) {
            case "say":
                System.out.println(this.argument);
                break;
            case "isint":
                try {
                    Integer.parseInt(this.argument);
                } catch (NumberFormatException | NullPointerException nfe) {
                    System.out.println("no");
                }
                System.out.println("yes");
        }

    }

    @Override
    public String toString() {
        return "running command " + this.name.toUpperCase();
    }
}
