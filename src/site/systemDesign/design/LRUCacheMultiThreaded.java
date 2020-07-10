package site.systemDesign.design;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
//https://codereview.stackexchange.com/questions/215075/java-thread-safe-lrucache-implementation
public class LRUCacheMultiThreaded<K, V> {

    private ConcurrentLinkedQueue<K> concurrentLinkedQueue = new ConcurrentLinkedQueue<K>();

    private ConcurrentHashMap<K, V> concurrentHashMap = new ConcurrentHashMap<K, V>();

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private Lock readLock = readWriteLock.readLock();

    private Lock writeLock = readWriteLock.writeLock();

    int maxSize = 0;

    public LRUCacheMultiThreaded(final int MAX_SIZE) {
        this.maxSize = MAX_SIZE;
    }

    public V getElement(K key) {
        readLock.lock();
        try {
            V v = null;
            if (concurrentHashMap.contains(key)) {
                concurrentLinkedQueue.remove(key);
                v = concurrentHashMap.get(key);
                addtoQueue(key);
            }
            return v;
        } finally {
            readLock.unlock();
        }
    }

    private synchronized void addtoQueue(K key) {
        concurrentLinkedQueue.add(key);
    }

    public V removeElement(K key) {
        writeLock.lock();
        try {
            V v = null;
            if (concurrentHashMap.contains(key)) {
                v = concurrentHashMap.remove(key);
                concurrentLinkedQueue.remove(key);
            }
            return v;
        } finally {
            writeLock.unlock();
        }
    }

    public V addElement(K key, V value) {
        writeLock.lock();
        try {
            if (concurrentHashMap.contains(key)) {
                concurrentLinkedQueue.remove(key);
            }
            while (concurrentLinkedQueue.size() >= maxSize) {
                K queueKey = concurrentLinkedQueue.poll(); //tail
                concurrentHashMap.remove(queueKey);
            }
            addtoQueue(key);
            concurrentHashMap.put(key, value);
            return value;
        } finally {
            writeLock.unlock();
        }
    }
}