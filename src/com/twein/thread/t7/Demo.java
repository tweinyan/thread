package com.twein.thread.t7;

/**
 * 保证可见性的前提
 *
 * 多个线程拿到的是同一把锁，
 *
 * Created by tweinyan on 04/04/2018.
 */
public class Demo {
    public volatile int a = 1;

//    public synchronized int getA() {
//        return a;
//    }
//
//    public synchronized void setA(int a) {
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        this.a = a;
//    }

    public static void main(String[] args) {
        Demo d = new Demo();
        d.a = 10;
        //new Thread(new Runnable() {
        //    @Override
        //    public void run() {
        //        d.a = 10;
        //    }
        //}).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(d.a);
            }
        }).start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(d.a);
    }
}
