package LeetCode2;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private LinkedHashMap<Integer,Integer> lru;
    public LRUCache(int capacity) {
        lru = new LinkedHashMap(capacity, 0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return lru.size() > capacity;
            }
        };
    }

    public int get(int key) {
        return lru.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        lru.put(key, value);
    }
}
