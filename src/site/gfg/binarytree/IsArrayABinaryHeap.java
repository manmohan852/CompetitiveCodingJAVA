package site.gfg.binarytree;

//https://www.geeksforgeeks.org/how-to-check-if-a-given-array-represents-a-binary-heap/?ref=rp
//represents a max-heap or not
public class IsArrayABinaryHeap {

    //Time complexity is O(n)
    static boolean isHeap(int arr[], int n) {
        for (int i = 0; i <= (n - 2) / 2; i++) {
            if (arr[2 * i + 1] > arr[i]) {
                return false;
            }
            if (2 * i + 2 < n && arr[2 * i + 2] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    //Time complexity is O(n)
    static boolean isHeapRecursive(int arr[], int i, int n) {
        if (i > (n - 2) / 2) {
            return true;
        }
        if (arr[i] >= arr[2 * i + 1] && arr[i] >= arr[2 * i + 2]
                && isHeapRecursive(arr, 2 * i + 1, n) && isHeapRecursive(arr, 2 * i + 2, n)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {90, 15, 10, 7, 12, 2, 7, 3};
        int n = arr.length;

        if (isHeapRecursive(arr, 0, n)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        if (isHeap(arr, n)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
