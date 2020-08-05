package site.interview.rupeek;

import java.util.HashMap;
import java.util.Map;

//https://www.faceprep.in/c-plus-plus/find-the-sum-of-all-odd-frequency-elements-in-an-array/
public class SumOfOddOccurringElementInanArray {

    public static int element(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int count = 0;
            if (map.get(arr[i]) != null) {
                count = map.get(arr[i]);
            }
            map.put(arr[i], count + 1);
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                sum += entry.getKey() * entry.getValue();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 2, 3, 3, 3};
        // sum should be = 1+1+2+2=6;
        int n = arr.length;
        System.out.println(element(arr, n));
    }
}
