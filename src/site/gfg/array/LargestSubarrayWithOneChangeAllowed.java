package site.gfg.array;
//https://www.geeksforgeeks.org/longest-increasing-subarray-with-one-change-allowed/
public class LargestSubarrayWithOneChangeAllowed {

    static int maxIncSubarr(int a[], int n) {
        int pre[] = new int[n];
        int pos[] = new int[n];
        pre[0] = 1;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] > a[i - 1]) {
                pre[i] = pre[i - 1] + 1;
                ans = Math.max(ans, pre[i]);
            }
            else
                pre[i] = 1;
        }
        if (ans != n)
            ++ans;

        pos[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] < a[i + 1])
                pos[i] = pos[i + 1] + 1;
            else
                pos[i] = 1;
        }

        for (int i = 1; i <= n - 2; i++) {
            if (a[i - 1] + 1 < a[i + 1])
                ans = Math.max(pre[i - 1] + pos[i + 1] + 1, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {9, 4, 5, 1, 13};
        int n = a.length;
        System.out.println(maxIncSubarr(a, n));
    }
}
