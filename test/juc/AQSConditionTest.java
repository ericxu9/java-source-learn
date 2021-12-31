package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用AQS condition实现生产者消费者
 */
public class AQSConditionTest {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("thread1 await before"); //1
                condition.await();
                System.out.println("thread1 await after");//4
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }).start();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("thread2 signal before");//2
                condition.signal();
                System.out.println("thread2 signal after"); //3
            }finally {
                lock.unlock();
            }

        }).start();
    }
}
