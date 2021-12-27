package juc;

import java.util.concurrent.locks.LockSupport;

/**
 * 测试先unpark后park
 * 可能，不会堵塞线程
 */
public class LockSupportTest2 {

    class MyThread extends Thread {

        Thread mainThread;

        public MyThread(Thread mainThread) {
            this.mainThread = mainThread;
        }

        @Override
        public void run() {
            System.out.println("before unpark");
            LockSupport.unpark(mainThread);
            System.out.println("after unpark");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new LockSupportTest2().new MyThread(Thread.currentThread());
        myThread.start();

        Thread.sleep(3000L);

        System.out.println("before park");
        LockSupport.park("ParkAndUnparkDemo");
        System.out.println("after park");

    }
}
