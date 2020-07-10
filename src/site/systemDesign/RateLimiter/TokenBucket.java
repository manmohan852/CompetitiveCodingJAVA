package site.systemDesign.RateLimiter;

public class TokenBucket {

    private final long maxBucketSize;
    private final long refillRate;
    private double currentBucketSize;
    private long lastRefillTimestamp;

    public TokenBucket(long maxBucketSize, long refillRate){
        this.maxBucketSize = maxBucketSize;
        this.refillRate = refillRate;
        currentBucketSize = maxBucketSize;
        lastRefillTimestamp = System.nanoTime();
    }

    private void refill(){
        long now = System.nanoTime();
        double tokensToAdd = (now - lastRefillTimestamp) * refillRate / 10e9;
        currentBucketSize = Math.min(currentBucketSize + tokensToAdd,maxBucketSize);
        lastRefillTimestamp = now;
    }

    public synchronized boolean allowRequest(int tokenRequired){
        refill();
        if(currentBucketSize >= tokenRequired){
            currentBucketSize = currentBucketSize - tokenRequired;
            return true;
        }
        return false;
    }
}
