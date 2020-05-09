package site.interview;

public class HashMapCustom {
    public void testMyMap() {
        MyMap<String, String> myMap = new MyMap<>();
        myMap.put("USA", "Washington DC");
        myMap.put("Nepal", "Kathmandu");
        myMap.put("India", "New Delhi");
        myMap.put("Australia", "Sydney");
        myMap.put("ASA", "Washington DC");
        myMap.put("Bepal", "Kathmandu");
        myMap.put("Tndia", "New Delhi");
        myMap.put("Eustralia", "Sydney");
        myMap.put("WSA", "Washington DC");
        myMap.put("Qepal", "Kathmandu");
        myMap.put("Undia", "New Delhi");
        myMap.put("Fustralia", "Sydney");
        myMap.put("SSA", "Washington DC");
        myMap.put("Gepal", "Kathmandu");
        myMap.put("Andia", "New Delhi");
        myMap.put("Vustralia", "Sydney");

        int bucketsSize = myMap.getBucketSize();
        for (int i = 0; i < bucketsSize; i++) {
            MyMap.Entry<String, String> ithBucket = myMap.buckets[i];
            while (ithBucket != null) {
                System.out.println(String.format("key: " + ithBucket.key + " " + " value: " + ithBucket.value));
                ithBucket = ithBucket.next;
            }
        }
    }

    public static void main(String[] args) {
        HashMapCustom hashMapCustom = new HashMapCustom();
        hashMapCustom.testMyMap();
    }
}

class MyMap<K, V> {
    public Entry<K, V>[] buckets;
    private static final int INITIAL_CAPACITY = 1 << 4; // 16 // no of buckets

    private int size = 0; // no of elements stored so far

    public MyMap() {
        this(INITIAL_CAPACITY);
    }

    public MyMap(int capacity) {
        this.buckets = new Entry[capacity];
    }

    public void put(K key, V value) {
        Entry<K, V> entry = new Entry<>(key, value, null);

        int bucket = getHash(key) % getBucketSize();

        Entry<K, V> existing = buckets[bucket];
        if (existing == null) {
            buckets[bucket] = entry;
            size++;
        } else {
            // compare the keys see if key already exists
            while (existing.next != null) {
                if (existing.key.equals(key)) {
                    existing.value = value;
                    return;
                }
                existing = existing.next;
            }

            if (existing.key.equals(key)) {
                existing.value = value;
            } else {
                existing.next = entry;
                size++;
            }
        }
    }

    public V get(K key) {
        Entry<K, V> bucket = buckets[getHash(key) % getBucketSize()];

        while (bucket != null) {
            if (key == bucket.key) {
                return bucket.value;
            }
            bucket = bucket.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public int getBucketSize() {
        return buckets.length;
    }

    private int getHash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Entry entry : buckets) {
            sb.append("[");
            while (entry != null) {
                sb.append(entry);
                if (entry.next != null) {
                    sb.append(", ");
                }
                entry = entry.next;
            }
            sb.append("]");
        }
        return "{" + sb.toString() + "}";
    }

    static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;

            if (obj instanceof Entry) {
                Entry entry = (Entry) obj;

                return key.equals(entry.getKey()) &&
                        value.equals(entry.getValue());
            }
            return false;
        }

        @Override
        public int hashCode() {
            int hash = 13;
            hash = 17 * hash + ((key == null) ? 0 : key.hashCode());
            hash = 17 * hash + ((value == null) ? 0 : value.hashCode());
            return hash;
        }

        @Override
        public String toString() {
            return "{" + key + ", " + value + "}";
        }
    }
}