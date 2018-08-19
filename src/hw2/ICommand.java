package hw2;

/**
 * all commands implements this
 *
 * @author Aleksandr Kurov
 * @version dated Авг. 19, 2018
 */

public interface ICommand {

    public void run() throws SimpleBotException;
    public String getName();

}
