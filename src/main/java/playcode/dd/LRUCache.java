package playcode.dd;

import java.util.*;

public class LRUCache {

    private Map<Integer, Integer> cache;
    private int capacity;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            int val = cache.get(key);
            cache.remove(key);
            cache.put(key, val);
            return val;
        }
        return -1;
    }

    public void put(int key, int value) {
        //remove is mandatory
        cache.remove(key);
        cache.put(key, value);
        if (cache.size() > capacity) {
            cache.remove(cache.keySet().iterator().next());
        }
    }
}
