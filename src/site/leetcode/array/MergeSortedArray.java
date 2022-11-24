package site.leetcode.array;
//https://leetcode.com/articles/merge-sorted-arrays/
public class MergeSortedArray {

    public static void merge(int[] a, int m, int[] b, int n) {
        int aIndex = m - 1;
        int bIndex = n - 1;
        int mergeIndex = a.length - 1;

        while (aIndex >= 0 && bIndex >= 0) {
            if (a[aIndex] > b[bIndex]) {
                a[mergeIndex] = a[aIndex];
                aIndex--;
            } else {
                a[mergeIndex] = b[bIndex];
                bIndex--;
            }
            mergeIndex--;
        }
        while (bIndex >= 0) {
            a[mergeIndex] = b[bIndex];
            bIndex--;
            mergeIndex--;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 5, 9, 14, 543, 0, 0, 0, 0, 0, 0};
        int[] b = {0, 53, 103, 125, 1000, 1200};
        merge(a, 6, b, 6);
    }
}
