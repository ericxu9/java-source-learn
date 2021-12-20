package thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WaitNotifyExample {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        WaitNotifyExample example = new WaitNotifyExample();
        exec.execute(new Runnable() {
            @Override
            public void run() {
                example.after();
            }
        });
        exec.execute(new Runnable() {
            @Override
            public void run() {
                example.before();
            }
        });
        exec.shutdown();
    }

    public synchronized void before() {
        System.out.println("before");
        notify(); //唤醒 after 挂起的线程
    }

    public synchronized void after() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after");
    }
}
