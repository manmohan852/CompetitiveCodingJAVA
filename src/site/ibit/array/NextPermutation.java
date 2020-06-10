package site.ibit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//https://www.interviewbit.com/problems/next-permutation/
public class NextPermutation {

    public static void nextPermutation(ArrayList<Integer> a) {
        int n = a.size();
        int index = -1;
        for (int i = n - 1; i > 0; i--) {
            if (a.get(i) > a.get(i - 1)) {
                index = i - 1;
                break;
            }
        }
        if (index == -1) {
            Collections.sort(a);
        } else {
            int swapWithIndex = -1;
            for (int j = n - 1; j > index; j--) {
                if (a.get(j) > a.get(index)) {
                    swapWithIndex = j;
                    break;
                }
            }
            int temp = a.get(index);
            a.set(index, a.get(swapWithIndex));
            a.set(swapWithIndex, temp);
            Collections.sort(a.subList(index + 1, n));
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,2,3,5,45,78,4));
//        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,2,3,4));
        nextPermutation(a);
    }
}
