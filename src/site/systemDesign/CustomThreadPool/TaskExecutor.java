package site.systemDesign.CustomThreadPool;

public class TaskExecutor implements Runnable {
    CustomBlockingQueue<Runnable> queue;

    public TaskExecutor(CustomBlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String name = Thread.currentThread().getName();
                Runnable task = queue.dequeue();
                System.out.println("Task Started by Thread :" + name);
                task.run();
                System.out.println("Task Finished by Thread :" + name);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
