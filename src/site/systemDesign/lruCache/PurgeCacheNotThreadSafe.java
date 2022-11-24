package site.systemDesign.lruCache;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class PurgeCacheNotThreadSafe<T> implements Runnable {

    private final BlockingQueue<ListNode<CacheEntity<T>>> taskQueue;
    private final ConcurrentHashMap<T, ListNode<CacheEntity<T>>> map;
    private final DoublyLinkedList<CacheEntity<T>> lruList = new DoublyLinkedList<>();
    private final int cacheSize;

    public PurgeCacheNotThreadSafe(BlockingQueue<ListNode<CacheEntity<T>>> blockingQueue,
                                   ConcurrentHashMap<T, ListNode<CacheEntity<T>>> cacheMap, int cacheSize) {
        this.taskQueue = blockingQueue;
        this.cacheSize = cacheSize;
        this.map = cacheMap;
    }

    public void run() {
        ListNode<CacheEntity<T>> taskNode;

        try {
            taskNode = this.taskQueue.take();
//            logger.info("Processing cache element: {}", taskNode.value.getKey());
        } catch (InterruptedException ex) {
            throw new RuntimeException("Thread interrupted, Stop Purging " + ex.getMessage());
        }

        if (!taskNode.value.getInCache()) {
            if (this.lruList.getSize() > cacheSize) {
                ListNode<CacheEntity<T>> deletedNode = this.lruList.deleteLastNode();
                this.map.remove(deletedNode.value.getKey());
//                logger.info("Removed cache element: " + deletedNode.value.getKey());
            }

            this.lruList.insertFirst(taskNode);
            taskNode.value.setInCache(true);

        } else {
            this.lruList.delete(taskNode);
            this.lruList.insertFirst(taskNode);
//            logger.info("Refreshed cache element: " + taskNode.value.getKey());
        }
    }
}