package com.twein.thread.t5;

/**
 * 双重检查加锁
 * Created by tweinyan on 03/04/2018.
 */
public class Singleton2 {
    private Singleton2() {}

    // 减少虚拟机优化，防止指令重排
    private static volatile Singleton2 instance;

    public static Singleton2 getInstance () {
        // 自旋 while(true)
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2(); // 指令重排序，仍然不是线程安全

                    // 申请一块内存空间 1
                    // 在这块空间里实例化对象 2
                    // instance的引用指向这块空间地址 3
                }
            }
        }
        return instance;
    }
}
