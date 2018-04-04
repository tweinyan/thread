package com.twein.thread.t4;

/**
 * Created by tweinyan on 29/03/2018.
 */
public class Target implements Runnable{
    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
