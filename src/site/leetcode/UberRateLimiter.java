package site.leetcode;
//        Whenever you expose a web service / api endpoint, you need to implement a rate limiter to prevent abuse of the service (DOS attacks).
//        Implement a RateLimiter Class with an isAllow method. Every request comes in with a unique clientID,
//        deny a request if that client has made more than 100 requests in the past second.

//Solution Approach:
//        I think you need to use a hash table lookup for each clientID. Then each clientID will have a queue of 100 max size.
//        The queue will hold timestamps.
//
//        Say you have a clientID with a list of 100 elements already in it.
//        Check the last added element's timestamp with the current time which will be at the end of queue.
//        If they are less than or equal to one second from each other then you know you are about to add the 101th request
//        within one second apart, so return false. Remember to pop and push even if you are returning false.
//        Therefore, everything is O(1) run-time with O(N*100) space, N being number of clientIDs.
//
//        An even more optimized solution is to use a pooling technique. For each clientID, has a pool of 100 elements.
//        Instead of a queue, use a circular queue. That way you don't waste time creating and deleting objects.
//        When you add a new timestamp, just move the head pointer back one and modify.
//        When you want to check the timestamp, just check the one behind the head pointer.
//
//        EDIT: The solution must use a timescale of milliseconds or better.
//        If you were to use seconds, it wouldn't be exact enough.
//        The seconds will be rounded up or down and you would lose precision.
//        Even a tenth of a second would not be enough. If you had 100 requests at 0.1 of a second,
//        then later you get another request at 1.1 of a second. How would you know that
//        it was exactly 1.1 or 1.099 or 1.101?? 1.101 is passed one second.

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/discuss/interview-question/124558/Implement-a-Rate-Limiter/
//https://leetcode.com/playground/wGHWEekd
public class UberRateLimiter {
    public int REQUEST_LIMIT = 3; // in interview it was 100.
    public Long TIME_LIMIT = 1000L;

    public class HitCounter {
        public Queue<Long> queue;

        public HitCounter() {
            queue = new LinkedList<>();
        }

        public boolean hit(long timestamp) {
            /* when a timestamp hit, we should poll all the timestamp before TIME_LIMIT*/
            while (!queue.isEmpty() &&  timestamp - queue.peek() >= TIME_LIMIT) queue.poll();
            if (queue.size() < REQUEST_LIMIT) {
                queue.add(timestamp);
                return true;
            }
            return false;
        }
    }

    public HashMap<String, HitCounter> clientTimeStampMap = new HashMap<>();

    public boolean isAllow(String clientId) {
        long currTime = System.currentTimeMillis();
        if (!clientTimeStampMap.containsKey(clientId)) {
            HitCounter h = new HitCounter();
            clientTimeStampMap.put(clientId, h);
            h.hit(currTime);
            return true;
        } else {
            HitCounter h = clientTimeStampMap.get(clientId);
            return h.hit(currTime);
        }
    }

    public static void main(String[] args) {
        UberRateLimiter limiter = new UberRateLimiter();
        System.out.println("test1 " + limiter.isAllow("test1"));
        System.out.println("test1 " +limiter.isAllow("test1"));
        System.out.println("test1 " +limiter.isAllow("test1"));
        System.out.println("test1 " +limiter.isAllow("test1"));
        System.out.println("test2 " +limiter.isAllow("test2"));
        System.out.println("test2 " +limiter.isAllow("test2"));
        System.out.println("test2 " +limiter.isAllow("test2"));
        System.out.println("test2 " +limiter.isAllow("test2"));
        System.out.println("test1 " +limiter.isAllow("test1"));
        System.out.println("Sleeping for 1 second");
        try {
            java.lang.Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        System.out.println("test1 " + limiter.isAllow("test1"));
        System.out.println("test1 " +limiter.isAllow("test1"));
        System.out.println("test1 " +limiter.isAllow("test1"));
        System.out.println("test1 " +limiter.isAllow("test1"));
        System.out.println("test2 " +limiter.isAllow("test2"));
        System.out.println("test2 " +limiter.isAllow("test2"));
        System.out.println("test2 " +limiter.isAllow("test2"));
        System.out.println("test2 " +limiter.isAllow("test2"));
        System.out.println("test1 " +limiter.isAllow("test1"));
    }

}
