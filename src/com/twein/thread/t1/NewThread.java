package com.twein.thread.t1;

/**
 * Created by tweinyan on 28/03/2018.
 */
public class NewThread implements Runnable{
    @Override
    public synchronized void run() {
        while (true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("自定义的线程运行了。。");
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    public static void main(String[] args) {
        NewThread n = new NewThread();
        Thread thread = new Thread(n); // 创建线程, 并指定线程任务

        thread.start();

        while (true) {
            synchronized (n) {
                System.out.println("主线程运行了。。。");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                n.notifyAll();
            }
        }
    }
}
