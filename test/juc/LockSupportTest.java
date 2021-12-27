package juc;

import java.util.concurrent.locks.LockSupport;

/**
 * 测试 park/unpark
 */
public class LockSupportTest {

    class MyThread extends Thread {

        private Object obj;

        public MyThread(Object obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            System.out.println("before unpark");
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("blocker info " + LockSupport.getBlocker((Thread) obj));
            //释放许可
            LockSupport.unpark((Thread) obj);
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //再次获取blocker
            System.out.println("blocker info " + LockSupport.getBlocker((Thread) obj));

            System.out.println("after unpark");
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new LockSupportTest().new MyThread(Thread.currentThread());
        myThread.start();
        System.out.println("before park");
        LockSupport.park("ParkAndUnparkDemo");
        System.out.println("after park");
    }
}
