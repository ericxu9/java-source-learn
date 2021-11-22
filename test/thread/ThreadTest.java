package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author xumiao
 * @description 线程扫盲
 * @date 2020/4/28 下午10:22
 */
public class ThreadTest {

    public static void main(String[] args) {
        testDaemon();
    }

    public static void createThread1() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("run");
            }
        };
        thread.start();
    }

    public static void createThread2() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        });
        thread.start();
    }

    public static void createThread3() {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                // futureTask.get()等待返回结果
                Thread.sleep(100);
                return 1;
            }
        });
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            //print 1
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * main方法中调用，main方法属于非守护进程
     */
    public static void testDaemon(){
        Thread daemonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //直接中断
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("daemon");
            }
        });
        daemonThread.setDaemon(true);
        daemonThread.start();
    }
}
