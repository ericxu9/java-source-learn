package thread.lock;

/**
 * class级别锁
 */
public class SynchronizeClassLockTest implements Runnable{

    static SynchronizeClassLockTest instance = new SynchronizeClassLockTest();
    static SynchronizeClassLockTest instance2 = new SynchronizeClassLockTest();

    public static void main(String[] args) {
        Thread threadA = new Thread(instance);
        Thread threadB = new Thread(instance2);
        threadA.start();
        threadB.start();
    }

    @Override
    public void run() {
        synchronized (SynchronizeClassLockTest.class) {
            System.out.println("我是线程：" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 退出");
        }
    }
}
