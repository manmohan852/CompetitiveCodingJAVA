package site.systemDesign.design;

import java.util.LinkedHashMap;

public class LRUCacheusingLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

//    We will be extending LinkedHashMap class provided by Java to implement our LRUCache.
//    LinkedHashMap can order the elements in Insertion order as well as Access order.
//        By default, LinkedHashMap maintains the data in Insertion order.
//    However in this case, we will be configuring LinkedHashMap to maintain the data in Access order by
//    setting the accessOrder flag to true in its three argument copy constructor.
//    Additionally, we will override method removeEldestEntry that LinkedHashMap calls after
//    every put method call to check whether it should remove the eldest element. In our implementation,
//    we will return true when size becomes greater than the capacity to let LinkedHashMap remove the least recently accessed element.

    private static final long serialVersionUID = 1L;
    private final int capacity;

    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        // Remove the eldest element whenever size of cache exceeds the capacity
        return (size() > this.capacity);
    }

    public LRUCacheusingLinkedHashMap(int capacity) {
        // Call constructor of LinkedHashMap with accessOrder set to true to
        // achieve LRU Cache behavior
        super(capacity + 1, 1.0f, true);
        this.capacity = capacity;
    }


    public V find(K key) {
        return super.get(key);
    }

    public void set(K key, V value) {
        super.put(key, value);
    }

    public static void main(String[] args) {
        // Create the cache with capacity 2
        LRUCacheusingLinkedHashMap<Integer, Integer> cache = new LRUCacheusingLinkedHashMap<>(
                2);

        cache.set(2, 1); // Will add an element with key as 2 and value as 1
        cache.set(3, 2); // Will add an element with key as 3 and value as 2

        // Will add an element with key as 4 and value as 3. Also will remove
        // the element with key 2 as it was added least recently and cache can
        // just have two elements at a time
        cache.set(4, 3);

        // Since element with key 2 was removed, it will return null
        System.out.println(cache.find(2));

        // It will return value 2 and move the element with key 3 to the head.
        // After this point, element with key 4 will be least recently accessed
        System.out.println(cache.find(3));

        // Will add an element with key as 5 and value as 4. Also will remove
        // the element with key 4 as it was accessed least recently and cache
        // can just have two elements at a time
        cache.set(5, 4);

        // Since element with key 2 was removed, it will return null
        System.out.println(cache.find(4));
    }
}