package site.systemDesign.CustomThreadPool;


public class CustomThreadPool {
    CustomBlockingQueue<Runnable> queue;
    public CustomThreadPool(int queueSize, int nThread) {
        queue = new CustomBlockingQueue<>(queueSize);
        String threadName = null;
        TaskExecutor task = null;
        for (int count = 0; count < nThread; count++) {
            threadName = "Thread-"+count;
            task = new TaskExecutor(queue);
            Thread thread = new Thread(task, threadName);
            thread.start();
        }
    }

    public void submitTask(Runnable task) throws InterruptedException {
        queue.enqueue(task);
    }
}
