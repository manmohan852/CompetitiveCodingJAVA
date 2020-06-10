package site.byteToByte;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//multiple repeating numbers will also get printed.
public class FindDuplicates {


    //Doesnt work for the case when array has zero or multiple zeros.
    public static List<Integer> findDuplicates1(int[] arr) {
        // Use a set for results to avoid duplicates
        Set<Integer> resultSet = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            // Translate the value into an index (1 <= x <= len(arr))
            int index = Math.abs(arr[i]) - 1;

            // If the value at that index is negative, then we've already seen
            // that value so it's a duplicate. Otherwise, negate the value at
            // that index so we know we've seen it
            if (arr[index] < 0) {
                resultSet.add(Math.abs(arr[i]));
            } else {
                arr[index] = -arr[index];
            }
        }

        // Return the array to it's original state
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.abs(arr[i]);
        }

        return new ArrayList<>(resultSet);
    }

    //https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
    //work for zero case also.
    public static void findDuplicates2() {
        int numRay[] = {0, 4, 3, 2, 7, 8, 2, 3, 1};

        for (int i = 0; i < numRay.length; i++) {
            numRay[numRay[i] % numRay.length] = numRay[numRay[i] % numRay.length] + numRay.length;
        }
        System.out.println("The repeating elements are : ");
        for (int i = 0; i < numRay.length; i++) {
            if (numRay[i] >= numRay.length * 2) {
                System.out.println(i + " ");
            }
        }
    }

    //https://www.geeksforgeeks.org/duplicates-array-using-o1-extra-space-set-2/
    //int arr[] = {1, 6, 3, 1, 3, 6, 6};
    static void printRepeating(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            int index = arr[i] % n;
            arr[index] += n;
        }
        for (int i = 0; i < n; i++) {
            if ((arr[i] / n) > 1)
                System.out.println(i + " ");
        }
    }

}
