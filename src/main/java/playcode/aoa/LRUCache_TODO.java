package playcode.aoa;
import java.util.*;
class LRUCache_TODO {
    private Map<Integer, Integer> map;
    private Deque<Integer> stack;
    private int limit;

    public LRUCache_TODO(int capacity) {
        stack = new ArrayDeque<>();
        map = new HashMap<>();
        limit = capacity;
    }
    public int get(int key) {
        if(map.containsKey(key)){
            update(key, map.get(key));
            return map.get(key);
        }
        return -1;

    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            update(key, value);
            return;
        }
        map.put(key, value);
        stack.addFirst(key);
        if(map.size()>limit){
            int last = stack.removeLast();
            map.remove(last);

        }
    }

    private void update(int key, int value){
        map.put(key, value);

        stack.addFirst(key);
    }
}
