package hw2;

/**
 * commands without network
 *
 * @author Aleksandr Kurov
 * @version dated Авг. 19, 2018
 */
public class LocalCommand extends Command implements ICommand{

    public LocalCommand(String name, String argument) {
        super(name, argument);
    }

    @Override
    public void run() throws SimpleBotException {

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
                break;
            default: throw new SimpleBotException("unsupported command " + this.name.toUpperCase(), 100, this.name);
        }

    }

    @Override
    public String toString() {
        return "running command " + this.name.toUpperCase();
    }
}
