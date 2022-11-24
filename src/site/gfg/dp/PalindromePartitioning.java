package site.gfg.dp;

//https://www.geeksforgeeks.org/palindrome-partitioning-dp-17/
//Determine the fewest cuts needed for palindrome partitioning of a given string.
public class PalindromePartitioning {
    public static boolean isPalindrome(String X, int i, int j) {
        while (i <= j) {
            if (X.charAt(i++) != X.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    //Approach 1
    //Time Complexity : O(2^n), Space Complexity : O(1)
    public static int minPalinPartition(String X, int i, int j) {
        // base case: if starting index i and ending index j are equal
        // or X[i..j] is already a palindrome.
        if (i == j || isPalindrome(X, i, j)) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            // recur to get minimum cuts required in X[i..k] and X[k+1..j]
            int count = 1 + minPalinPartition(X, i, k) +
                    minPalinPartition(X, k + 1, j);
            if (count < min)
                min = count;
        }
        return min;
    }

    //Approach 2
    // Iterative function to find the minimum cuts needed in a String
    // such that each partition is a palindrome
    public static int minPalinPartition(String X, boolean[][] isPalin) {
        // create a lookup table to store solutions of sub-problems
        // lookup[i] stores the minimum cuts needed in substring X[i..n)

        int[] lookup = new int[X.length()];

        // start from String's end
        for (int i = X.length() - 1; i >= 0; i--) {
            lookup[i] = Integer.MAX_VALUE;

            // if X[i...n-1] is a palindrome, total cuts needed is 0
            if (isPalin[i][X.length() - 1]) {
                lookup[i] = 0;
            } else {
                // else find lookup[i]
                for (int j = X.length() - 2; j >= i; j--) {
                    if (isPalin[i][j]) {
                        lookup[i] = Integer.min(lookup[i], 1 + lookup[j + 1]);
                    }
                }
            }
        }

        return lookup[0];
    }

    // Bottom-up DP function to mark if String X[i..j] is a palindrome
    // or not for all possible values of i and j
    public static void findAllPalindromes(String X, boolean[][] isPalin) {
        for (int i = X.length() - 1; i >= 0; i--) {
            for (int j = i; j < X.length(); j++) {
                if (i == j) {
                    isPalin[i][j] = true;
                } else if (X.charAt(i) == X.charAt(j)) {
                    isPalin[i][j] = ((j - i == 1) ? true : isPalin[i + 1][j - 1]);
                } else {
                    isPalin[i][j] = false;
                }
            }
        }
    }


    public static void main(String[] args) {
        //approach 1
        String X = "BABABCBADCD";
        System.out.print("The minimum cuts required are "
                + minPalinPartition(X, 0, X.length() - 1));
        //approach2
        String XY = "BABABCBADCEDE";
        // BAB|ABCBA|D|C|EDE
        // isPalin[i][j] stores if substring X[i][j] is palindrome or not
        boolean[][] isPalin = new boolean[X.length() + 1][X.length() + 1];

        // find all substrings of X that are palindromes
        findAllPalindromes(X, isPalin);

        System.out.println("The minimum cuts required are "
                + minPalinPartition(X, isPalin));
    }
}