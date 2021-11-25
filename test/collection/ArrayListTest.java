package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ff
 */
public class ArrayListTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4);
        List<Integer> list2 = new ArrayList<>(list);
        list2.add(1);
        System.out.println(list2);
        System.out.println(16 << 1);
    }
}
