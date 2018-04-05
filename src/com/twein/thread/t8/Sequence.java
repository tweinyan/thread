package com.twein.thread.t8;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by tweinyan on 30/03/2018.
 */
public class Sequence {
    // private static int value;
    private AtomicInteger value = new AtomicInteger(0);

    private int[] s = {2, 1, 4, 6};

    AtomicIntegerArray a = new AtomicIntegerArray(s);

    // 抽象类型
    AtomicReference<User> user = new AtomicReference<>();

    // 更新一个类的Integer类型的字段
    AtomicIntegerFieldUpdater<User> old = AtomicIntegerFieldUpdater.newUpdater(User.class, "old");
    /**
     * @return
     */
    public int getNext() {

        User user = new User();
        //old.getAndIncrement(user);
        System.out.println(old.getAndIncrement(user));
        System.out.println(old.getAndIncrement(user));
        System.out.println(old.getAndIncrement(user));

        //System.out.println(user.getOld());

        a.getAndIncrement(2);
        a.getAndAdd(2, 10);
        return value.getAndIncrement();
    }


    public static void main(String[] args) {
        Sequence s = new Sequence();
        //while (true) {
        //    System.out.println(s.getNext());
        //}
        new Thread(new Runnable() {
            @Override
            public void run() {
//                while (true) {
                    System.out.println(Thread.currentThread().getName() + " " + s.getNext());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
//            }
        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    System.out.println(Thread.currentThread().getName() + " " + s.getNext());
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    System.out.println(Thread.currentThread().getName() + " " + s.getNext());
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
    }
}
