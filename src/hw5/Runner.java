package hw5;

import java.util.Arrays;

/**
 * Homework #5
 *
 * @author Aleksandr Kurov
 * @version dated Август 30, 2018
 */
public class Runner implements Runnable {

    static final int size = 10000000;
    static final int h = size / 2;
    float[] arr = new float[size];
    float[] a1 = null;
    float[] a2 = null;


    public static void main(String[] args) {
        Runner r = new Runner();

        // task 1
        Arrays.fill(r.arr, 1.f);
        r.task1();

        // task 2
        Arrays.fill(r.arr, 1.f);
        r.task2();
    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("t1")) {
            for (int i = 0; i < h; i++) {
                a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5)
                        * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        } else {
            for (int i = 0; i < h; i++) {
                a2[i] = (float) (a2[i] * Math.sin(0.2f + i / 5)
                        * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }
    }

    private void task1() {
        System.out.print("One Thread time: ");
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5)
                    * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
    }

    private void task2() {
        System.out.print("Two Threads time: ");
        long a = System.currentTimeMillis();

        a1 = new float[h];
        a2 = new float[h];

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread t1 = new Thread(this, "t1");
        t1.start();
        Thread t2 = new Thread(this, "t2");
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.println(System.currentTimeMillis() - a);

    }
}
