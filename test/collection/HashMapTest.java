package collection;

import java.util.HashMap;

public class HashMapTest {

    public static void main(String[] args) {
        HashMap<String, Object> hashMap = new HashMap<>(8);
        hashMap.put("a", 1);
        hashMap.put("b", 1);
        hashMap.put("name", 100);
        hashMap.put("age", 20);
        hashMap.put("subject", 20);
        hashMap.put("test", 1);
        hashMap.put("gender", 0);
        hashMap.put("max", 0);
        hashMap.put("min", 0);
        System.out.println(hashMap);
    }
}
