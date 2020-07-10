package site.byteToByte;
//https://leetcode.com/problems/median-of-two-sorted-arrays/solution/

//Complexity Analysis:
//        Time Complexity: O(m + n).
//        To merge both the arrays O(m+n) time is needed.
//        Space Complexity: O(1).
//        No extra space is required.
public class MedianOfArrays2 {
    /* This function returns median of ar1[] and ar2[].
    Assumption in this function:
    Both ar1[] and ar2[] are sorted arrays */
    static int getMedian(int ar1[], int ar2[], int n, int m) {
        int i = 0; /* Current index of input array ar1[] */
        int j = 0; /* Current index of input array ar2[] */
        int count;
        int m1 = -1, m2 = -1;

        // Since there are (n+m) elements,
        // There are following two cases
        // if n+m is odd then the middle
        //index is median i.e. (m+n)/2
        if ((m + n) % 2 == 1) {
            for (count = 0; count <= (n + m) / 2; count++) {
                if (i != n && j != m) {
                    m1 = (ar1[i] > ar2[j]) ? ar2[j++] : ar1[i++];
                } else if (i < n) {
                    m1 = ar1[i++];
                }
                // for case when j<m,
                else {
                    m1 = ar2[j++];
                }
            }
            return m1;
        }

        // median will be average of elements
        // at index ((m+n)/2 - 1) and (m+n)/2
        // in the array obtained after merging ar1 and ar2
        else {
            for (count = 0; count <= (n + m) / 2; count++) {
                m2 = m1;
                if (i != n && j != m) {
                    m1 = (ar1[i] > ar2[j]) ? ar2[j++] : ar1[i++];
                } else if (i < n) {
                    m1 = ar1[i++];
                }
                // for case when j<m,
                else {
                    m1 = ar1[j++];
                }
            }
            return (m1 + m2) / 2;
        }
    }

    //https://leetcode.com/problems/median-of-two-sorted-arrays/solution/
    //Time complexity: O(log(min(m,n))).
    //Space complexity: O(1).
    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = i + 1; // i is too small
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = i - 1; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }


    public static void main(String[] args) {
        int ar1[] = {900};
        int ar2[] = {5, 8, 10, 20}; //loop ends at j=2, ans = 10

        int ar3[] = {1,2};
        int ar4[] = {3,4}; // loop ends at j=0 and i=2, ans = (2+3)/2 = 2.5

        int n1 = ar1.length;
        int n2 = ar2.length;
        findMedianSortedArrays(ar3, ar4);
    }
}
