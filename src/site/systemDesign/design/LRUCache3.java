package site.systemDesign.design;

import java.util.TreeMap;

//https://www.interviewbit.com/problems/lru-cache/
public class LRUCache3 {

    private static int t = 0;

    private static final class Item {
        int key, val, time;

        Item(int key, int val, int time) {
            this.key = key;
            this.val = val;
            this.time = time;
        }
    }

    private TreeMap<Integer, Item> keyMap;
    private TreeMap<Integer, Item> timeMap;
    private final int capacity;

    public LRUCache3(int capacity) {
        keyMap = new TreeMap<>();
        timeMap = new TreeMap<>();
        this.capacity = capacity;
        t = 0;
    }

    private void updateTime(Item item) {
        timeMap.remove(item.time);
        timeMap.put(item.time = t++, item);
    }

    public int get(int key) {
        if (!keyMap.containsKey(key)) return -1;
        Item item = keyMap.get(key);
        updateTime(item);
        return item.val;
    }

    public void set(int key, int value) {
        if (keyMap.containsKey(key)) {
            Item item = keyMap.get(key);
            updateTime(item);
            item.val = value;
        } else {
            if (keyMap.size() == capacity) {
                Item item = timeMap.firstEntry().getValue();
                timeMap.remove(item.time);
                keyMap.remove(item.key);
            }

            Item item = new Item(key, value, t++);
            keyMap.put(item.key, item);
            timeMap.put(item.time, item);
        }
    }
}
