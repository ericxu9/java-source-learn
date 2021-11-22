import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReferenceTypesTest {

    public static void main(String[] args) {
        testSoftRef();
//        testWeakRef();
//        testPhantomRef();
    }

    public static void testSoftRef() {
        SoftReference<byte[]> softRef1 = new SoftReference<>(new byte[1024 * 300]);
        SoftReference<byte[]> softRef2 = new SoftReference<>(new byte[1024 * 300]);
        SoftReference<byte[]> softRef3 = new SoftReference<>(new byte[1024 * 300]);
        SoftReference<byte[]> softRef4 = new SoftReference<>(new byte[1024 * 300]);
        SoftReference<byte[]> softRef5 = new SoftReference<>(new byte[1024 * 300]);

        System.out.println(softRef1.get());
        System.out.println(softRef2.get());
        System.out.println(softRef3.get());
        System.out.println(softRef4.get());
        System.out.println(softRef5.get());
    }

    public static void testWeakRef() {
        byte[] buffer = new byte[1024 * 500];
        WeakReference<byte[]> weakReference = new WeakReference<>(buffer);
        System.out.println("GC前：" + weakReference.get());
        buffer = null;
        //手动触发GC
        System.gc();
        System.out.println("GC后：" + weakReference.get());
    }

    public static void testPhantomRef() {
        byte[] buffer = new byte[1024 * 500];
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<byte[]> phantomReference = new PhantomReference<>(buffer,referenceQueue);
        buffer = null;
        System.out.println("GC前：" + phantomReference.get());
        System.gc();
        System.out.println("GC后：" + phantomReference.get());
    }
}
