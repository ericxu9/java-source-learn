package jvm.classloader;

/**
 * 双亲委派测试
 */
public class ParentsDelegationTest {

    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader); //sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(classLoader.getParent()); //sun.misc.Launcher$ExtClassLoader@6e0be858
        System.out.println(classLoader.getParent().getParent());//null ,BootstrapClassLoader是C++实现的
    }
}
