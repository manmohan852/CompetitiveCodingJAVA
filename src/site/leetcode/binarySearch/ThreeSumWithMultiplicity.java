package site.leetcode.binarySearch;

import java.util.Arrays;

//https://leetcode.com/problems/3sum-with-multiplicity/
public class ThreeSumWithMultiplicity {

    //Time Complexity: O(N^2)
    //Space Complexity: O(1)
    public static int threeSumMulti(int[] A, int target) {
        int MOD = 1_000_000_007;
        long ans = 0;
        Arrays.sort(A);
        for (int i = 0; i < A.length; ++i) {
            int T = target - A[i];
            int j = i + 1, k = A.length - 1;
            while (j < k) {
                if (A[j] + A[k] < T)
                    j++;
                else if (A[j] + A[k] > T)
                    k--;
                else if (A[j] != A[k]) {
                    int left = 1, right = 1;
                    while (j + 1 < k && A[j] == A[j + 1]) {
                        left++;
                        j++;
                    }
                    while (k - 1 > j && A[k] == A[k - 1]) {
                        right++;
                        k--;
                    }
                    ans += left * right;
                    ans %= MOD;
                    j++;
                    k--;
                } else {
                    ans += (k - j + 1) * (k - j) / 2;
                    ans %= MOD;
                    break;
                }
            }
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        int target = 8;
        threeSumMulti(A, target);
    }

}
