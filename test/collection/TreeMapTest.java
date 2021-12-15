package collection;

import java.util.TreeMap;

public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap<Integer, Object> treeMap = new TreeMap<>();
        treeMap.put(5, null);
        treeMap.put(3, null);
        treeMap.put(1, null);
        treeMap.put(3, null);
        System.out.println(treeMap.size());
        System.out.println(treeMap);
    }
}
