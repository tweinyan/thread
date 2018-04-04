package com.twein.thread.t4;

/**
 * Created by tweinyan on 29/03/2018.
 */
public class Demo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Target());
        Thread t2 = new Thread(new Target());
        Thread t3 = new Thread(new Target());
        Thread t4 = new Thread(new Target());
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
    }
}
