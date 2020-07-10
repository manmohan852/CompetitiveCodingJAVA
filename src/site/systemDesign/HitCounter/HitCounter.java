package site.systemDesign.HitCounter;


import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;
//https://medium.com/@thomaspoignant/algorithmic-design-a-hit-counter-4bc6400152a
/**
 * HitCounter count the number of request in a specific range of time.
 */
public class HitCounter {
    // hits, array where each row is the number of hits for this second,
    // we use AtomicInteger because it is thread safe.
    private final AtomicInteger[] hits;
    // times, array where each row is a timestamp, it is here to keep track
    // of which timestamp has already been in the counter in the last X seconds.
    private final long[] times;
    // rangeInSecond, the number of seconds we need to keep.
    private final int rangeInSecond;

    /**
     * Constructor for a HitCounter
     *
     * @param rangeInSecond, number of seconds to keep
     */
    public HitCounter(final int rangeInSecond) {
        this.rangeInSecond = rangeInSecond;
        this.times = new long[rangeInSecond];

        // Init the array with an AtomicInteger of 0.
        this.hits = Stream.generate(() -> new AtomicInteger(0))
                .limit(rangeInSecond)
                .toArray(AtomicInteger[]::new);
    }

    /**
     * hit, is called for each new request and increment the counter
     * for the second of the request.
     *
     * @param timestamp, the timestamp of the request
     */
    public void hit(final long timestamp) {
        final int idx = Math.toIntExact(timestamp % rangeInSecond);
        if (times[idx] != timestamp) {
            // we should re-initialize the number of request
            hits[idx].set(1);
            times[idx] = timestamp;
            return;
        }
        hits[idx].addAndGet(1);
    }

    /**
     * getHits, compute the number of request in the last X seconds.
     *
     * @return number of request in the last X seconds.
     */
    public long getHits() {
        final var timestamp = Instant.now().getEpochSecond();
        // We filter to get only the hits from the last X seconds.
        return IntStream.range(0, times.length)
                .filter(i -> timestamp - times[i] < this.rangeInSecond)
                .map(i -> hits[i].get())
                .reduce(0, Integer::sum);

    }
}