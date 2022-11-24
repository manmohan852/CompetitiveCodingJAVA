package site.ibit.array;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.interviewbit.com/problems/find-permutation/
public class FindPermutation {
    public ArrayList<Integer> findPerm(final String A, int B) {
        int smallest = 1;
        int largest = B;
        ArrayList<Integer> op = new ArrayList<Integer>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'D') {
                op.add(largest);
                largest = largest - 1;
            } else {
                op.add(smallest);
                smallest = smallest + 1;
            }
        }
        op.add(smallest);
        return op;
    }
    public ArrayList<Integer> findPerm2(final String A, int B) {
        int smallest = 1;
        int largest = B;
        int[] res = new int[B];
        for (int i = A.length()-1; i >=0; i--) {
            if (A.charAt(i) == 'D') {
                res[i+1] = largest--;
            } else {
                res[i+1] = smallest++;
            }
        }
        res[0] = smallest;
        ArrayList<Integer> result = new ArrayList<>(B);
        for (int i=0; i<B; i++) result.add((res[i]));
        return result;
    }


}
