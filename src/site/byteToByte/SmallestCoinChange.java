package site.byteToByte;

public class SmallestCoinChange {

    public int change(int x, int[] coins) {
        if (x == 0) return 0;

        int min = x;
        for (int coin : coins) {
            if (x - coin >= 0) {
                int c = change(x - coin, coins);
                if (min > c + 1) min = c + 1;
            }
        }
        return min;
    }

    public int changeDynamic(int x, int[] coins) {
        int[] cache = new int[x];
        for (int i = 1; i < x; i++) {
            cache[i] = -1;
        }
        return changeDynamic(x, coins, cache);
    }

    public int changeDynamic(int x, int[] coins, int[] cache) {
        if (x == 0) return 0;

        int min = x;
        for (int coin : coins) {
            if (x - coin >= 0) {
                int c;
                if (cache[x - coin] >= 0) c = cache[x - coin];
                else {
                    c = changeDynamic(x - coin, coins, cache);
                    cache[x - coin] = c;
                }
                if (min > c + 1) min = c + 1;
            }
        }
        return min;
    }
}
