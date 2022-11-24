package site.ibit.dp;

import java.util.ArrayList;
import java.util.HashSet;

//https://www.interviewbit.com/problems/length-of-longest-fibonacci-subsequence/
public class LengthOfLongestFibonacciSubsequence {

    //this works because the input is strictly increasing.
    //Timecomplexity  = O(n2)
    public int solve(ArrayList<Integer> A) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int X : A)
            set.add(X);

        int max = Integer.MIN_VALUE;
        boolean flag = true;
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                int first = A.get(i);
                int second = A.get(j);
                int sum = first + second;
                int count = 2;
                while (set.contains(sum)) {
                    flag = false;
                    first = second;
                    second = sum;
                    sum = first + second;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        if (flag == true)
            return 0;
        return max;
    }
}
