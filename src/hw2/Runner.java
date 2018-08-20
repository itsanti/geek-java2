package hw2;

import hw2.arraytask.ArrTask;
import hw2.arraytask.MyException;

import hw2.SimpleBotException;

/**
 * Homework #2
 *
 * @author Aleksandr Kurov
 * @version dated Август 19, 2018
 */
public class Runner {
    public static void main(String[] args) {

        // Array Task
        String[][] data1 = new String[][] {
                {"a", "b"},
                {"c", "d"}
        };

        String[][] data2 = new String[][] {
                {"a", "b"},
                {"c", "d"},
                {"e", "f"},
                {"g", "h"}
        };

        String[][] data3 = new String[][] {
                {"23", "b", "c", "d"},
                {"c", "d", "e", "f"},
                {"e", "f", "g", "h"},
                {"g", "h", "i", "j"}
        };

        String[][] data4 = new String[][] {
                {"11", "22", "33", "44"},
                {"55", "66", "77", "88"},
                {"99", "12", "23", "34"},
                {"56", "67", "78", "89"}
        };

        try {

            //ArrTask.sumArrayElements(data1);
            //ArrTask.sumArrayElements(data2);
            //ArrTask.sumArrayElements(data3);
            System.out.println("sum of data4 elements: " + ArrTask.sumArrayElements(data4));

        } catch (MyException e) {

            System.out.println(e.getMessage());

        }


        // SimpleBot Project
        SimpleBot sbot = new SimpleBot();
        sbot.addCommand(new LocalCommand("say", "hi"));
        sbot.addCommand(new LocalCommand("isint", "2"));
        // add unsupported command
        sbot.addCommand(new LocalCommand("alarm", "ZzZ"));

        try {

            for (ICommand cmd : sbot.getCommands()) {
                cmd.run();
            }

        } catch (SimpleBotException e) {
            System.out.println("ERROR[" + e.getErrCode() +"]: " + e.getMessage());
            sbot.rmCommand(e.getErrArgs());
        } finally {
            System.out.println(sbot.getCommands());
        }

    }
}
