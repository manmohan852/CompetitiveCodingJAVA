package site.byteToByte;

public class fibonacci {
    public long fibonacci(int x) {
        if (x < 0) return -1;
        if (x == 0) return 0;
        long[] cache = new long[x + 1];
        for (int i = 1; i < cache.length; i++) { cache[i] = -1; }
        cache[1] = 1;
        return fibonacci(x, cache);
    }

    private long fibonacci(int x, long[] cache) {
        if (cache[x] > -1) return cache[x];
        cache[x] = fibonacci(x - 1, cache) + fibonacci(x - 2, cache);
        return cache[x];
    }
}
