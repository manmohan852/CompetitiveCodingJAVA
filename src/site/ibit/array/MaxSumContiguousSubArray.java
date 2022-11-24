package site.ibit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
//Contiguous : Touching/Connecting
public class MaxSumContiguousSubArray {

    public static int maxSubArray(final List<Integer> A) {
        int maxEndingHere = A.get(0);
        int maxSoFar = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            maxEndingHere = Math.max(A.get(i), A.get(i) + maxEndingHere);
            //OR maxEndingHere = A.get(i) +  Math.max(0,maxEndingHere);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public int maxSubArray2(final List<Integer> A) {
        int currMax = A.get(0);
        int tempMax = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) > tempMax + A.get(i)) {
                tempMax = A.get(i);
            } else {
                tempMax += A.get(i);
            }
            if (currMax < tempMax) {
                currMax = tempMax;
            }
        }
        return currMax;
    }

    public static void main(String[] args) {
//        List<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4, -10));
        List<Integer> A = new ArrayList<>(Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4));
        maxSubArray(A);
    }
}
