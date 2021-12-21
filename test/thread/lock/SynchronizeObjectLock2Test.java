package thread.lock;

/**
 * 修改普通方法，锁对象默认是this，当前对象
 */
public class SynchronizeObjectLock2Test implements Runnable{

    static SynchronizeObjectLockTest instance = new SynchronizeObjectLockTest();

    public static void main(String[] args) {
        Thread threadA = new Thread(instance);
        Thread threadB = new Thread(instance);
        threadA.start();
        threadB.start();
    }

    @Override
    public void run() {
        method();
    }

    public synchronized void method() {
        System.out.println("我是线程：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 退出");
    }
}
