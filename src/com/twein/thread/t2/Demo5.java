package com.twein.thread.t2;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by tweinyan on 29/03/2018.
 */
public class Demo5 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("timertask is run");
            }
        }, 0, 1000);
    }
}