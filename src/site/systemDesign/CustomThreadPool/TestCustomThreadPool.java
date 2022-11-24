package site.systemDesign.CustomThreadPool;
//https://makeinjava.com/custom-thread-pool-java-example-without-executor-framework/
public class TestCustomThreadPool {
    public static void main(String[] args) throws InterruptedException {
        //create queue size - 3
        //Number of threads - 4
        CustomThreadPool threadPool = new CustomThreadPool(3,4);
        //Created 15 Tasks and submit to pool
        for(int taskNumber = 1 ; taskNumber <= 7; taskNumber++) {
            TestTask task = new TestTask(taskNumber);
            threadPool.submitTask(task);
        }
    }
}
