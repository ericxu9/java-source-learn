package jvm.classloader;

import java.io.*;
import java.util.Arrays;

/**
 * 自定义classloader
 */
public class FileSystemClassLoader extends ClassLoader{

    private String rootDir;

    public FileSystemClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] getClassData(String className) {
        String path = classNameToPath(className);
        try {
            InputStream ins = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead;
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String classNameToPath(String className) {
        return rootDir + File.separatorChar
                + className.replace('.', File.separatorChar) + ".class";
    }


    public static void main(String[] args) throws ClassNotFoundException {
        FileSystemClassLoader fileSystemClassLoader = new FileSystemClassLoader("/Users/xuyongjun/KeepRunning/java-source-learn/out/test/java-source-learn");
        Class<?> arrayListTest = fileSystemClassLoader.loadClass("ReferenceTypesTest");
        System.out.println(arrayListTest);

        //除了将类加载到jvm，还会执行static代码块
        Class<?> referenceTypesTest = Class.forName("ReferenceTypesTest");
        System.out.println(referenceTypesTest);
    }
}
