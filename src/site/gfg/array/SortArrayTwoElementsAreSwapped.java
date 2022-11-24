package site.gfg.array;

import java.util.List;
//https://www.geeksforgeeks.org/sort-an-almost-sorted-array-where-only-two-elements-are-swapped/
public class SortArrayTwoElementsAreSwapped {
    static void sortByOneSwap(int arr[], int n) {
        for (int i = n - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                int j = i - 1;
                while (j >= 0 && arr[i] < arr[j])
                    j--;
                int temp = arr[i];
                arr[i] = arr[j + 1];
                arr[j + 1] = temp;
                break;
            }
        }
    }

    public int[] findTwoSwapped(List<Integer> nums) {
        int n = nums.size();
        int x = -1, y = -1;
        for (int i = 0; i < n - 1; ++i) {
            if (nums.get(i + 1) < nums.get(i)) {
                y = nums.get(i + 1);
                // first swap occurence
                if (x == -1) x = nums.get(i);
                    // second swap occurence
                else break;
            }
        }
        return new int[]{x, y};
    }
}
