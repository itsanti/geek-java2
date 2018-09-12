package hw8;

import hw8.client.Client;
import hw8.server.MServer;
import javafx.application.Application;

/**
 * Homework #8
 *
 * @author Aleksandr Kurov
 * @version dated Сентябрь 12, 2018
 */
public class Runner {
    public static void main(String[] args) {
        new Thread(() -> new MServer()).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        new Thread(() -> Application.launch(Client.class, args)).start();
    }
}
