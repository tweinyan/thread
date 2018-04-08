package com.twein.thread.ta1;

/**
 * Created by tweinyan on 08/04/2018.
 */
public class Demo {
    MyLock lock = new MyLock();

    public void a() {
        lock.lock();
        System.out.println("a");
        b();
        lock.unlock();
    }

    public void b() {
        lock.lock();
        System.out.println("b");
        c();
        lock.unlock();
    }
    public void c() {
        lock.lock();
        System.out.println("c");
        lock.unlock();
    }

    public static void main(String[] args) {
        Demo d = new Demo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                d.a();
            }
        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                d.b();
//            }
//        }).start();

    }
}
