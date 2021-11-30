package collection;

import java.util.ArrayDeque;

public class ArrayDequeTest {

    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>(30);
        arrayDeque.addFirst(1);
        arrayDeque.addFirst(2);
        arrayDeque.addFirst(3);
        arrayDeque.addFirst(4);
        arrayDeque.addFirst(5);
        arrayDeque.addFirst(6);
        arrayDeque.addFirst(7);
        arrayDeque.addFirst(8);
        arrayDeque.pollLast();
//        arrayDeque.addLast(9);
//        arrayDeque.addLast(10);
        System.out.println(arrayDeque);
    }
}
