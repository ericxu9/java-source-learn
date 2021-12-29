package juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试线程同步，针对性查看AQS源码
 */
public class ReentrantLockTest {

    class MyThread extends Thread {

        private Lock lock;
        private String name;

        public MyThread(Lock lock, String name) {
            this.lock = lock;
            this.name = name;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println("thread name " + name + " running.");
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        MyThread t1 = new ReentrantLockTest().new MyThread(reentrantLock, "t1");
        MyThread t2 = new ReentrantLockTest().new MyThread(reentrantLock, "t2");
        t1.start();
        t2.start();
    }
}
