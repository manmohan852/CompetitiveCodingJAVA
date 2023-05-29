package MySite.LeetCode.BinarySearch;
// https://leetcode.com/problems/koko-eating-bananas/description/
public class kokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++){
            max = Math.max(max, piles[i]);
        }
        if(h == piles.length) return max;
        int lo = 0;
        int hi = max;
        int speed = Integer.MAX_VALUE;
        while(lo <= hi){
            int sp = lo + (hi - lo) / 2;
            if(isPossible(piles, sp, h)){
                speed = sp;
                hi = sp - 1;
            }
            else lo = sp + 1;
        }
        return speed;
    }
    public boolean isPossible(int[] piles, int speed, int h){
        long time = 0;
        for(int i = 0; i < piles.length; i++){
            time += (int)Math.ceil(piles[i] * 1.0 / speed);
        }
        return time <= h;
    }
}
