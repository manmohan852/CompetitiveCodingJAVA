package site.gfg.binarySearch;

//https://www.geeksforgeeks.org/count-number-of-occurrences-or-frequency-in-a-sorted-array/
public class FrequencyInSortedArray {


    //Time Complexity: O(n)
    static int countOccurrences1(int arr[], int n, int x) {
        int res = 0;
        for (int i = 0; i < n; i++)
            if (x == arr[i])
                res++;
        return res;
    }

    static int binarySearch(int arr[], int l, int r, int x) {
        if (r < l)
            return -1;
        int mid = l + (r - l) / 2;
        if (arr[mid] == x)
            return mid;
        if (arr[mid] > x)
            return binarySearch(arr, l, mid - 1, x);
        return binarySearch(arr, mid + 1, r, x);
    }

    //Time Complexity : O(Log n + count) where count is number of occurrences.
    static int countOccurrences2(int arr[], int n, int x) {
        int ind = binarySearch(arr, 0, n - 1, x);
        if (ind == -1)
            return 0;
        int count = 1;
        int left = ind - 1;
        while (left >= 0 &&
                arr[left] == x) {
            count++;
            left--;
        }
        int right = ind + 1;
        while (right < n && arr[right] == x) {
            count++;
            right++;
        }
        return count;
    }


    //Time Complexity: O(Logn)
    static int countOccurrences3(int arr[], int x, int n) {
        int i;
        int j;
        i = first(arr, 0, n - 1, x, n);
        if (i == -1)
            return i;
        j = last(arr, i, n - 1, x, n);
        return j - i + 1;
    }

    static int first(int arr[], int low, int high, int x, int n) {
        if (high >= low) {
            int mid = (low + high) / 2;
            if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x)
                return mid;
            else if (x > arr[mid])
                return first(arr, (mid + 1), high, x, n);
            else
                return first(arr, low, (mid - 1), x, n);
        }
        return -1;
    }

    static int last(int arr[], int low, int high, int x, int n) {
        if (high >= low) {
            int mid = (low + high) / 2;
            if ((mid == n - 1 || x < arr[mid + 1]) && arr[mid] == x)
                return mid;
            else if (x < arr[mid])
                return last(arr, low, (mid - 1), x, n);
            else
                return last(arr, (mid + 1), high, x, n);
        }
        return -1;
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 2, 3, 3, 3, 3};
        int x = 3;
        int n = arr.length;
        int c = countOccurrences3(arr, x, n);
        System.out.println(x + " occurs " + c + " times");
    }
}
