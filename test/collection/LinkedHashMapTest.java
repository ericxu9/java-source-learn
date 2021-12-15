package collection;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapTest {

    public static void main(String[] args) {
        Map<String, Object> linkedHashMap = new LinkedHashMap<>(16,0.75f,true);
        linkedHashMap.put("b", 1);
        linkedHashMap.put("a", 2);
        linkedHashMap.put("c", 3);
        linkedHashMap.put("b", 2);
        //编译后，这边会转成iterator，通过while来遍历
        Set<Map.Entry<String, Object>> entries = linkedHashMap.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry.getKey());
        }
    }
}
