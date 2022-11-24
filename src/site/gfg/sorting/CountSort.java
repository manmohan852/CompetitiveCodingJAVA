package site.gfg.sorting;

import java.util.Arrays;

//https://www.geeksforgeeks.org/counting-sort/
public class CountSort {

    //Canot be used for negative numbers, as no provison for negative indexes
    //Time Complexity: O(n+k),where n is the number of elements in input array and k is the range of input.
    //Space Complexity: O(n+k)
    public static void countSort1(char arr[]) {
        int n = arr.length;
        // The output character array that will have sorted arr
        char output[] = new char[n];
        // Create a count array to store count of inidividul
        // characters and initialize count array as 0
        int count[] = new int[256];
        for (int i = 0; i < 256; ++i)
            count[i] = 0;
        // store count of each character
        for (int i = 0; i < n; ++i)
            ++count[arr[i]];
        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i = 1; i <= 255; ++i)
            count[i] += count[i - 1];
        // Build the output character array
        // To make it stable we are operating in reverse order.
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }
        for (int i = 0; i < n; ++i)
            arr[i] = output[i];
    }

    //Can be used for negative numbers
    //Time Complexity: O(n+k),where n is the number of elements in input array and k is the range of input.
    //Space Complexity: O(n+k)
    public static void countSort2(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int count[] = new int[range];
        int output[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

//    Points to be noted:
//        1. Counting sort is efficient if the range of input data is not significantly greater than
//    the number of objects to be sorted. Consider the situation where the input
//    sequence is between range 1 to 10K and the data is 10, 5, 10K, 5K.

//2. It is not a comparison based sorting. It running time complexity is O(n) with space proportional
//    to the range of data.
//            3. It is often used as a sub-routine to another sorting algorithm like radix sort.
//            4. Counting sort uses a partial hashing to count the occurrence of the data object in O(1).
//            5. Counting sort can be extended to work for negative inputs also.

    public static void main(String args[]) {
        char arr[] = {'g', 'e', 'e', 'k', 's', 'f', 'o',
                'r', 'g', 'e', 'e', 'k', 's'
        };
        char arr2[] = {1, 4, 1, 2, 7, 5, 2};
        //countSort1(arr2);
        int[] arr3 = {-5, -10, 0, -3, 8, 5, -1, 10};
        countSort2(arr3);


    }
}


