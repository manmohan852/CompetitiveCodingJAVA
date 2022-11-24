package site.systemDesign.HitCounter;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounterQueue {
    Queue<Integer> q;

    public HitCounterQueue() {
        q = new LinkedList<>();
    }

    public void hit(int timestamp) {
        q.add(timestamp);
    }

    public int getHits(int timestamp) {
        while (!q.isEmpty() && (timestamp - 300 >= q.peek()))
            q.poll();
        return q.size();
    }
}
