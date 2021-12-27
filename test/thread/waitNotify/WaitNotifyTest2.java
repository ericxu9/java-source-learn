package thread.waitNotify;

/**
 * 线程同步，执行结果如下
 * before wait
 * before notify
 * after notify
 * after wait
 */
public class WaitNotifyTest2 {

    class MyThread extends Thread {
        @Override
        public void run() {
            //阻塞，等待主线程中锁释放
            synchronized (this) {
                System.out.println("before notify");
                notify();
                System.out.println("after notify");
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new WaitNotifyTest2().new MyThread();
        synchronized (thread) { //这里锁对象和MyThread run方法中是同一个
            try {
                thread.start();
                Thread.sleep(3000);
                System.out.println("before wait");
                thread.wait();
                System.out.println("after wait");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
