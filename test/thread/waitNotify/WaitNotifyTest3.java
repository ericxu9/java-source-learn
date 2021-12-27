package thread.waitNotify;

/**
 * 先notify，后wait测试
 * 结果：不会释放锁
 */
public class WaitNotifyTest3 {

    class MyThread extends Thread {

        @Override
        public void run() {
            synchronized (this) {
                System.out.println("notify before");
                notify();
                System.out.println("notify after");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new WaitNotifyTest3().new MyThread();
        myThread.start();
        Thread.sleep(3000L);
        synchronized (myThread) {
            System.out.println("wait before");
            myThread.wait();
            System.out.println("wait after");
        }

    }
}
