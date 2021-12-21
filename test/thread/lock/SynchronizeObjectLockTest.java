package thread.lock;

/**
 * 对象锁，同一个对象才生效
 * 可以使用this或者自定义对象
 */
public class SynchronizeObjectLockTest implements Runnable{

    static SynchronizeObjectLockTest instance = new SynchronizeObjectLockTest();

    final Object lock = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(instance);
        Thread threadB = new Thread(instance);
        threadA.start();
        threadB.start();
    }

    @Override
    public void run() {
//        synchronized (this) {
        synchronized (lock) {
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
