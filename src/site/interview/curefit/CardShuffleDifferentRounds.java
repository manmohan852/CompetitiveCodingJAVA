package site.interview.curefit;

import java.util.*;
//https://www.geeksforgeeks.org/card-shuffle-problem-tcs-digital-advanced-coding-question/?ref=rp
class CardShuffleDifferentRounds {

    static final int CARDS = 100;

    // Function to perform the current round
    static void currentRound(List<Integer> list, int totalPiles) {

        // Create the required empty piles
        List<List<Integer>> piles = new ArrayList<>();
        for (int i = 0; i < totalPiles; i++)
            piles.add(new ArrayList<Integer>());

        // Add cards to the piles one by one
        int j = 0;
        for (int i = 0; i < CARDS; i++) {
            piles.get(j).add(list.get(i));
            j = (j + 1) % totalPiles;
        }

        // After all the piles have been reversed
        // the new order will be first card of the
        // first pile, second card of the first
        // pile, ..., last pile of the last pile
        // (from top to bottom)
        int pileNo = 0, i = 0;
        j = 0;
        while (i < CARDS) {
            list.set(i, piles.get(pileNo).get(j));
            j++;
            if (j >= piles.get(pileNo).size()) {
                pileNo++;
                j = 0;
            }
            i++;
        }
    }

    // Function to perform all the rounds
    static int performRounds(int piles[], int rounds, int n) {

        // Create the initial list with all the cards
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= CARDS; i++)
            list.add(i);

        // Perform all the rounds
        for (int i = 0; i < rounds; i++)
            currentRound(list, piles[i]);

        // Return the nth card
        return list.get(n);
    }

    // Driver code
    public static void main(String[] args) {
        int piles[] = {2, 2};
        int rounds = piles.length;
        int n = 4;

        // nth card will be at (n - 1)th index
        n--;
        performRounds(piles, rounds, n);
    }
}
