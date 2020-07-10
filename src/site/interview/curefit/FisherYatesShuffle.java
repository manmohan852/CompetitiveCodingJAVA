package site.interview.curefit;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

//https://www.geeksforgeeks.org/shuffle-a-deck-of-cards-3/?ref=rp
//https://www.geeksforgeeks.org/shuffle-a-given-array-using-fisher-yates-shuffle-algorithm/
// Java Code for Shuffle a deck of cards
public class FisherYatesShuffle {

    //Time Complexity = O(n)
    //Time Complexity for random number generation is O(1)
    public static void shuffle(int card[], int n) {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int r = i + rand.nextInt(52 - i);
            int temp = card[r];
            card[r] = card[i];
            card[i] = temp;
        }
    }

    //Time Complexity = O(n)
    //Time Complexity for random number generation is O(1)
    static void randomize(int arr[], int n) {
        Random r = new Random();
        for (int i = n - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

    }

    //java doc
    //https://repository.microej.com/javadoc/microej_4.0/addons/java/util/Collections.html#shuffle-java.util.List-
    static void shuffle2(int arr[], int n){
        //This implementation traverses the list backwards, from the last element up to the second,
        // repeatedly swapping a randomly selected element into the "current position".
        // Elements are randomly selected from the portion of the list that runs from the first element to the current position, inclusive.
        Collections.shuffle(Arrays.asList(arr), new Random());
        Collections.shuffle(Arrays.asList(arr));
        Collections.shuffle(Arrays.asList(arr), new Random(3));
    }

    public static void main(String[] args) {
        // Array from 0 to 51
        int a[] = {0, 1, 2, 3, 4, 5, 6, 7, 8,
                9, 10, 11, 12, 13, 14, 15,
                16, 17, 18, 19, 20, 21, 22,
                23, 24, 25, 26, 27, 28, 29,
                30, 31, 32, 33, 34, 35, 36,
                37, 38, 39, 40, 41, 42, 43,
                44, 45, 46, 47, 48, 49, 50,
                51};
        shuffle(a, 52);
        System.out.println(Arrays.toString(a));
    }
}
