package site.interview.designDS;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/discuss/interview-question/189573/google-phone-screen-map-with-ttl-reject
public class TimeCriticalHashMap<K, V> {

    private Long limit;
    private Map<K, Pair<V, Long>> map = new HashMap<>();

    public TimeCriticalHashMap(Long limit) {
        this.limit = limit;
    }

    public synchronized V put(K key, V value) {
        Pair<V, Long> pair
                = map.put(key, new Pair(value, System.currentTimeMillis()));
        return pair != null ? pair.value : null;
    }

    public synchronized V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        Pair<V, Long> pair = map.get(key);
        if (System.currentTimeMillis() - pair.time <= limit) {
            return pair.value;
        }
        map.remove(key);
        return null;
    }

    private class Pair<V, Long> {
        private V value;
        private Long time;

        public Pair(V value, Long time) {
            this.value = value;
            this.time = time;
        }
    }
}