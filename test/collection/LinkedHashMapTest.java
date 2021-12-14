package collection;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapTest {

    public static void main(String[] args) {
        Map<String, Object> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("b", 1);
        linkedHashMap.put("a", 2);
        Set<Map.Entry<String, Object>> entries = linkedHashMap.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry.getKey());
        }
    }
}
