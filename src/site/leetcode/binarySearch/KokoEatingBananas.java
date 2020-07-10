package site.leetcode.binarySearch;
//https://leetcode.com/problems/koko-eating-bananas/
public class KokoEatingBananas {

    //Time Complexity: O(NlogW)
    //Space Complexity: O(1)
    public static int minEatingSpeed(int[] piles, int H) {
        int lo = 1;
        int hi = 1_000_000_000; // hi can also be the max value in piles.
        while (lo < hi) { //loop breaks when lo = hi
            int mi = (lo + hi) / 2;
            if (!possible(piles, H, mi))
                lo = mi + 1;
            else
                hi = mi;
        }
        return lo;
    }

    // Can Koko eat all bananas in H hours with eating speed K?
    public static boolean possible(int[] piles, int H, int K) {
        int time = 0;
        for (int p: piles)
            time += (p-1) / K + 1; //Math.ceil(P/K) = (P-1)/K
        return time <= H;
    }

    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int H = 8;
        minEatingSpeed(piles,H);

    }


}