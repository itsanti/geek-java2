package hw5;

/**
 * threads
 *
 * @author Aleksandr Kurov
 * @version dated Сент. 03, 2018
 */
public class TManual implements Runnable {
    Thread t;

    public static void main(String[] args) {
        // будет создан главный поток, им можно управлять
        Thread thread = Thread.currentThread();

        if (thread.getName().equals("main")) {
            new TManual();
        }

        System.out.println(thread.getName() + " isAlive: " + thread.isAlive());
        System.out.println(thread);

    }

    TManual() {
        t = new Thread(this, "child");
        t.start();
    }

    @Override
    public void run() {
        // точка входа дочернего потока
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TManual.main(new String[]{});
    }

}
