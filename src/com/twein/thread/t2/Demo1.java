package com.twein.thread.t2;

/**
 * Created by tweinyan on 29/03/2018.
 */
public class Demo1 extends Thread {
    public Demo1(String name) {
        super(name);
    }

    @Override
    public void run() {
        while(!interrupted()) {
            System.out.println(getName() + "线程执行了。。。");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Demo1 d1 = new Demo1("first-thread");
        Demo1 d2 = new Demo1("second-thread");
        d1.start();
        d2.start();
        d1.interrupt();
    }
}
