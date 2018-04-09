package com.twein.thread.ta4;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by tweinyan on 08/04/2018.
 */
public class MyLock2 implements Lock {

    private Helper helper = new Helper();
    @Override
    public void lock() {
        helper.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        helper.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return helper.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return helper.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        helper.release(1);
    }

    @Override
    public Condition newCondition() {
        return helper.newCondition();
    }

    private class Helper extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {
            // 如果第一个线程进来，可以拿到锁，因此我们可以返回true
            // 如果第二个线程进来，拿不到锁，返回false。有种特例，如果进来的线程和当前保存的线程是同一个线程，则可以拿到锁，但是有代价要更新状态值
            // 如何判断是第一个线程进来还是第二个线程进来？
            int state = getState();
            Thread t = Thread.currentThread();

            if(state == 0) {
                if(compareAndSetState(0, arg)) {
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            } else if (getExclusiveOwnerThread() == t) {
                setState(state + 1);
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            // 锁的获取和释放肯定是一一对应的，那么调用此方法的线程一定是当前线程
            if(Thread.currentThread() != getExclusiveOwnerThread()) {
                throw new RuntimeException();
            }
            int state = getState() - arg;

            boolean flag = false;

            if(state == 0) {
                setState(0);
                setExclusiveOwnerThread(null);
                flag = true;
            }
            setState(state);
            return flag;
        }

        Condition newCondition() {
            return new ConditionObject();
        }
    }

}
