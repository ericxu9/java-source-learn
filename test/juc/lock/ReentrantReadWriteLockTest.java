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
                System.out.println("write lock before -- thread A");
                writeLock.lock();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                writeLock.unlock();
                System.out.println("write lock after -- thread A");
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                System.out.println("read lock before -- thread B");
                readLock.lock();
                System.out.println("thread B");
                readLock.unlock();
                System.out.println("read lock after -- thread B");
            }
        }.start();
    }

}
