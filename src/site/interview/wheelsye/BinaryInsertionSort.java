package site.interview.wheelsye;

import java.util.Arrays;

public class BinaryInsertionSort {

    //BinaryInsertionSort
    public static void main(String[] args) {
        final int[] arr = {37, 23, 0, 17, 12, 72, 31,
                46, 100, 88, 54};
        binaryInsertionSort(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    //InsertionSort
    public static void main2(String args[]) {
        int arr[] = {12, 11, 13, 5, 6};
        insertionSort(arr);
        printArray(arr);
    }

    public static void binaryInsertionSort(int array[]) {
        for (int i = 1; i < array.length; i++) {
            int x = array[i];
            // Find location to insert using binary search
            int j = Math.abs(Arrays.binarySearch(array, 0, i, x) + 1);
            //Shifting array to one location right
            System.arraycopy(array, j, array, j + 1, i - j);
            //Placing element at its correct location
            array[j] = x;
        }
    }

    // Java program for implementation of Insertion Sort
     static void insertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

			/* Move elements of arr[0..i-1], that are
			greater than key, to one position ahead
			of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    /* A utility function to print array of size n*/
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


}

