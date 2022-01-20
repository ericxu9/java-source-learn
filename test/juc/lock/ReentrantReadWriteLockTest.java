package juc.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 1. 读读共享
 * 2. 写写互斥
 * 3. 读写互斥
 * 4. 写读互斥
 */
public class ReentrantReadWriteLockTest {

    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        new Thread(){
            @Override
            public void run() {
                System.out.println("read lock 1 before -- thread A");
                readLock.lock();
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                readLock.unlock();
                System.out.println("read unlock 1 after -- thread A");
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                System.out.println("read lock 2 before -- thread B");
                readLock.lock();
                System.out.println("thread B");
                readLock.unlock();
                System.out.println("read unlock 2 after -- thread B");
            }
        }.start();
    }

}
