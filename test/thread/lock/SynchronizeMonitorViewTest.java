package thread.lock;

/**
 * 使用javap -verbose查看class字节码信息
 * monitorenter
 * monitorexit
 */
public class SynchronizeMonitorViewTest {

    Object object = new Object();

    public void method() {
        synchronized (object) {
            method2();
        }

    }

    private static void method2() {

    }
}
