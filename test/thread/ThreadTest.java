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
        testJoin();
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
     * 当所有非守护线程结束时，程序也就终止，同时会杀死所有守护线程。
     * 下面不会执行
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

    public static void testJoin() {
        Thread aThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("A");
            }
        });
        Thread bThread = new Thread(new Runnable() {

            Thread thread;

            public Runnable setThread(Thread thread) {
                this.thread = thread;
                return this;
            }

            @Override
            public void run() {
                try {
                    thread.join(); //等待aThread执行完成
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B");
            }
        }.setThread(aThread));
        bThread.start();
        aThread.start();
    }
}
