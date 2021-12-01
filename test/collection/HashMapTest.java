package collection;

import java.util.HashMap;

public class HashMapTest {

    public static void main(String[] args) {
        HashMap<String, Object> hashMap = new HashMap<>(8);
        hashMap.put("a", 1);
        hashMap.put("b", 1);
        System.out.println(hashMap);
    }
}
