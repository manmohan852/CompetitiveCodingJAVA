package site.byteToByte;

public class TwoMissingNumbers {
    // Determine the single number that is missing.
// XOR the actual array and the expected array from 1 to N together. All
// the repeated numbers cancel out, leaving us with the desired result.
// (1 ^ 2 ^ ... ^ N-1 ^ N) ^ (1 ^ 2 ^ ... ^ N-1) = N
    public static int oneMissing(int[] arr) {
        int totalXor = 0;
        int arrXor = 0;

        // XOR the numbers from 1 to N, ie. the input if no numbers were missing
        for (int i = 1; i <= arr.length + 1; i++) totalXor ^= i;

        // XOR the input array
        for (int i : arr) arrXor ^= i;

        // XOR the two values together. x^x = 0 and x^0 = x. That means that any
        // repeated number cancels out, so we are left with the single
        // non-repeated number.
        // eg. (1 ^ 2 ^ ... ^ N-1 ^ N) ^ (1 ^ 2 ^ ... ^ N-1) = N
        return totalXor ^ arrXor;
    }

    // Determine the two numbers missing from an array. Returns an array of
// length 2
    public static int[] twoMissing(int[] arr) {
        int size = arr.length + 2;

        // 1 + 2 + ... + N-1 + N = N * (N + 1) / 2
        long totalSum = size * (size + 1) / 2;

        // Sum up the input array
        long arrSum = 0;
        for (int i : arr) arrSum += i;

        // totalSum - arrSum = the sum of the two results. Therefore we know
        // that since our two results are not equal, one result is
        // > (sum of two results) / 2 and the other is
        // < (sum of two results) / 2
        int pivot = (int) ((totalSum - arrSum) / 2);

        // Use the same technique as oneMissing() on each half of the array.
        int totalLeftXor = 0;
        int arrLeftXor = 0;
        int totalRightXor = 0;
        int arrRightXor = 0;

        for (int i = 1; i <= pivot; i++) totalLeftXor ^= i;
        for (int i = pivot + 1; i <= size; i++) totalRightXor ^= i;
        for (int i : arr) {
            if (i <= pivot) arrLeftXor ^= i;
            else arrRightXor ^= i;
        }

        return new int[]{totalLeftXor ^ arrLeftXor, totalRightXor ^ arrRightXor};
    }
}
