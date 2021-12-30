package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用AQS condition实现生产者消费者
 */
public class AQSConditionTest {

    class Depot {
        private int size;
        private int capacity;
        private Lock lock;
        private Condition fullCondition;
        private Condition emptyCondition;

        public Depot(int capacity) {
            this.capacity = capacity;
            lock = new ReentrantLock();
            fullCondition = lock.newCondition();
            emptyCondition = lock.newCondition();
        }

        public void produce(int no) {
            lock.lock();
            int left = no;
            try {
                while (left > 0) {
                    while (size >= capacity)  {
                        System.out.println(Thread.currentThread() + " before await");
                        fullCondition.await();
                        System.out.println(Thread.currentThread() + " after await");
                    }
                    int inc = (left + size) > capacity ? (capacity - size) : left;
                    left -= inc;
                    size += inc;
                    System.out.println("produce = " + inc + ", size = " + size);
                    emptyCondition.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void consume(int no) {
            lock.lock();
            int left = no;
            try {
                while (left > 0) {
                    while (size <= 0) {
                        System.out.println(Thread.currentThread() + " before await");
                        emptyCondition.await();
                        System.out.println(Thread.currentThread() + " after await");
                    }
                    int dec = (size - left) > 0 ? left : size;
                    left -= dec;
                    size -= dec;
                    System.out.println("consume = " + dec + ", size = " + size);
                    fullCondition.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    class Consumer {
        private Depot depot;
        public Consumer(Depot depot) {
            this.depot = depot;
        }

        public void consume(int no) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    depot.consume(no);
                }
            }, no + " consume thread").start();
        }
    }

    class Producer {
        private Depot depot;
        public Producer(Depot depot) {
            this.depot = depot;
        }

        public void produce(int no) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    depot.produce(no);
                }
            }, no + " produce thread").start();
        }
    }

    public static void main(String[] args) {
        Depot depot = new AQSConditionTest().new Depot(500);
        new AQSConditionTest().new Producer(depot).produce(500);
        new AQSConditionTest().new Producer(depot).produce(200);
        new AQSConditionTest().new Consumer(depot).consume(500);
        new AQSConditionTest().new Consumer(depot).consume(200);
    }
}
