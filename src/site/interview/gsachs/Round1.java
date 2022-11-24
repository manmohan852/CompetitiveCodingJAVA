package site.interview.gsachs;

public class Round1 {

    //    QUESTION 1
//    N = no of students
//    T = no of toys to distributed in sequentially in circular fashion
//    D = random position  from which you have to start distributing the toys
//    output  : last student id [1 to N] who get the last toy, last toy is damaged
    public static int findDamagedToy(int N, int T, int D) {
        T = T % N;
        int ans = 0;
        int i = D;
        while (T > 0) {
            if (i < N) {
                i++;
            } else {
                i = 1;
            }
            T--;
        }
        i--;
        ans = i;
        return ans == 0 ? N : ans;
    }

    //QUESTION 2
    //https://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/
//    https://www.interviewbit.com/problems/ways-to-decode/
//    A=1, B=2.... Z=26,, GIVEN AN INTEGER IN STRING, WE HAVE OUTPUT COUNT OF ALL STRING WHIHC CAN WE MADE FROM IT
    public static long calculatePossibleCombinations(String inputStr) {
        char[] arr = inputStr.toCharArray();
        int n = arr.length;
        long res = countDecodingDP(arr, n);
        System.out.println(res);
        return res;
    }

    //Time Complexity is O(n)
//    count[1] = take into account 1 character
//    count[2] = take into account 2 character
//    count[n] = take into account n character
    static long countDecodingDP(char digits[], int n) {
        long count[] = new long[n + 1];
        count[0] = 1;
        count[1] = 1;
        if (digits[0] == '0')   //for base condition "01123" should return 0
            return 0;
        for (int i = 2; i <= n; i++) {
            count[i] = 0;

            // If the last digit is not 0,
            // then last digit must add to
            // the number of words
            if (digits[i - 1] > '0')
                count[i] = count[i - 1];

            // If second last digit is smaller
            // than 2 and last digit is smaller
            // than 7, then last two digits
            // form a valid character
            if (digits[i - 2] == '1' ||
                    (digits[i - 2] == '2' &&
                            digits[i - 1] < '7'))
                count[i] += count[i - 2];
        }
        return count[n];
    }

    //BRUTE FORCE
    //Time complexity is exponential
    static int countDecoding(char[] digits, int n) {
        // base cases
        if (n == 0 || n == 1)
            return 1;

        // for base condition "01123" should return 0
        if (digits[0] == '0')
            return 0;

        // Initialize count
        int count = 0;

        // If the last digit is not 0, then
        // last digit must add to
        // the number of words
        if (digits[n - 1] > '0')
            count = countDecoding(digits, n - 1);

        // If the last two digits form a number
        // smaller than or equal to 26,
        // then consider last two digits and recur
        if (digits[n - 2] == '1' ||
                (digits[n - 2] == '2' && digits[n - 1] < '7'))
            count += countDecoding(digits, n - 2);

        return count;
    }


    public static void main(String[] args) {
//        findDamagedToy(5,7,4);
        calculatePossibleCombinations("2112");
    }
}
