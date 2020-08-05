package site.systemDesign.CustomThreadPool;

import java.util.LinkedList;
import java.util.Queue;

public class CustomBlockingQueue<R> {
    private Queue<Runnable> queue = new LinkedList<>();
    private int EMPTY = 0;
    private int MAX_TASK_IN_QUEUE = -1;

    public CustomBlockingQueue(int size){
        this.MAX_TASK_IN_QUEUE = size;
    }

    public synchronized void enqueue(Runnable task)
            throws InterruptedException  {
        while(this.queue.size() == this.MAX_TASK_IN_QUEUE) {
            wait();
        }
        if(this.queue.size() == EMPTY) {
            notifyAll();
        }
        this.queue.offer(task);
    }

    public synchronized Runnable dequeue()
            throws InterruptedException{
        while(this.queue.size() == EMPTY){
            wait();
        }
        if(this.queue.size() == this.MAX_TASK_IN_QUEUE){
            notifyAll();
        }
        return this.queue.poll();
    }
}
