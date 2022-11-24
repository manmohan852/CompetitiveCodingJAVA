package site.systemDesign.HitCounter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;
//https://leetcode.com/problems/design-hit-counter/
public class HitCounterLeetcode {

    private final AtomicInteger[] hits;
    private final long[] times;
    private final int rangeInSecond = 300;
    public HitCounterLeetcode() {
        this.times = new long[rangeInSecond];
        this.hits = Stream.generate(() -> new AtomicInteger(0))
                .limit(rangeInSecond)
                .toArray(AtomicInteger[]::new);
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        final int idx = Math.toIntExact(timestamp % rangeInSecond);
        if (times[idx] != timestamp) {
            // we should re-initialize the number of request
            hits[idx].set(1);
            times[idx] = timestamp;
            return;
        }
        hits[idx].addAndGet(1);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestampW - The current timestamp (in seconds granularity). */
    public int getHits(int timestampW) {
        final int timestamp = timestampW;
        // We filter to get only the hits from the last X seconds.
        return IntStream.range(0, times.length)
                .filter(i -> timestamp - times[i] < this.rangeInSecond)
                .map(i -> hits[i].get())
                .reduce(0, Integer::sum);
    }

}
