package hw6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * simple chat server
 *
 * @author Aleksandr Kurov
 * @version dated Сент. 02, 2018
 */
public class SChatServer {

    private static boolean isRunning = true;

    public static void run() {
        ServerSocket serv = null;
        Socket sock = null;
        try {
            // listen port 8189
            serv = new ServerSocket(8189);
            System.out.println("server is running");

            // main thread waiting for connections
            // new client will be assigned to sock variable
            sock = serv.accept();
            System.out.println("client connected");

            Scanner in = new Scanner(sock.getInputStream());
            PrintWriter pw = new PrintWriter(sock.getOutputStream());
            Scanner console = new Scanner(System.in);

            Thread ct = new Thread(new Runnable() {
                @Override
                public void run() {
                    String msg;
                    try {
                        while (true) {
                            msg = console.nextLine();
                            pw.println(msg);
                            pw.flush();
                            if (msg.equals("end")) {
                                isRunning = false;
                                break;
                            }
                        }
                    } catch (Exception e) {
                        e.getStackTrace();
                    }
                }
            });
            ct.start();

            while (isRunning) {
                if (in.hasNext()) {
                    String msg = in.nextLine();
                    if (msg.equalsIgnoreCase("end")) {
                        ct.stop();
                        break;
                    }
                    System.out.println(msg);
                }
            }

        } catch (IOException e) {
            System.out.println("[error] server init failed");
        } finally {
            try {
                serv.close();
                System.out.println("server stopped");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
