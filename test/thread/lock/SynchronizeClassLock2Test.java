package thread.lock;

/**
 * static修饰方法，默认为当前class作为锁
 */
public class SynchronizeClassLock2Test implements Runnable{

    static SynchronizeClassLock2Test instance = new SynchronizeClassLock2Test();
    static SynchronizeClassLock2Test instance2 = new SynchronizeClassLock2Test();

    public static void main(String[] args) {
        Thread threadA = new Thread(instance);
        Thread threadB = new Thread(instance2);
        threadA.start();
        threadB.start();
    }

    @Override
    public void run() {
        method();
    }

    public synchronized static void method() {
        System.out.println("我是线程：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 退出");
    }
}
