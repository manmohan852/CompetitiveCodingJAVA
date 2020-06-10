package site.interview;

//https://www.geeksforgeeks.org/maximum-length-of-strictly-increasing-sub-array-after-removing-at-most-one-element/
public class LargestIncreasingSubarrayRemoveAtMostOneElement {
    static int maxIncSubarr(int a[], int n) {
        int pre[] = new int[n];
        int pos[] = new int[n];
        pre[0] = 1;
        pos[n - 1] = 1;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] > a[i - 1]) {
                pre[i] = pre[i - 1] + 1;
                ans = Math.max(ans, pre[i]);
            } else
                pre[i] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] < a[i + 1])
                pos[i] = pos[i + 1] + 1;
            else
                pos[i] = 1;
        }
        for (int i = 1; i <= n - 2; i++) {
            if (a[i - 1] < a[i + 1])
                ans = Math.max(pre[i - 1] +
                        pos[i + 1], ans);
        }
        return ans;
    }

    public static void main(String[] args) {
//        int arr[] = {1, 2, 5, 3, 4};
        int arr[] = {1, 3, 4, 5, 3, 6, 7, 8, 9};
        int n = arr.length;

        System.out.println(maxIncSubarr(arr, n));
    }
}

