package site.gfg.array;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/duplicates-array-using-o1-extra-space-set-3/
public class FindDuplicates2 {

    //elements lies in range of 1 to n-1; n is the size of the array
    public static int findDuplicate(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        int ptr1 = arr[0];
        int ptr2 = slow;
        while (ptr1 != ptr2) {
            ptr1 = arr[ptr1];
            ptr2 = arr[ptr2];
        }
        return ptr1;
    }

    //https://www.geeksforgeeks.org/find-duplicates-given-array-elements-not-limited-range/
    //elements  are out of range : Input : {2, 10, 100, 2, 10, 11}
    private static void printDuplicates(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        boolean dup = false;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                count = map.get(arr[i]);
                map.put(arr[i], count + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.print(entry.getKey() + " ");
                dup = true;
            }
        }
        if (!dup) {
            System.out.println("-1");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1};
        System.out.println("" + findDuplicate(arr));
    }
}
