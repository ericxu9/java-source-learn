package juc.collection;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueTest {

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<Integer>(1024);
        new Thread(){
            @Override
            public void run() {
                try {
                    q.put(1);
                    sleep(1000L);
                    q.put(2);
                    sleep(1000L);
                    q.put(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println(q.take());
                    System.out.println(q.take());
                    System.out.println(q.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
