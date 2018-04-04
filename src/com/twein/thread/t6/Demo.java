package com.twein.thread.t6;

/**
 * Created by tweinyan on 03/04/2018.
 */
public class Demo {
    public synchronized void a() {
        System.out.println("a");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void b() {
        System.out.println("b");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Demo d1 = new Demo();
        Demo d2 = new Demo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                d1.a();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                d2.b();
            }
        }).start();
    }
}
