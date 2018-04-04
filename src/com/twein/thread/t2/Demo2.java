package com.twein.thread.t2;

/**
 *
 * 最为线程任务存在
 *
 * Created by tweinyan on 29/03/2018.
 */
public class Demo2 implements Runnable {
    @Override
    public void run() {
        while(true) {
            System.out.println("thread running ...");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Demo2());
        thread.start();
    }
}
