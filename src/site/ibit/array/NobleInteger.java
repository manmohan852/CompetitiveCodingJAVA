package site.ibit.array;

import java.util.ArrayList;
import java.util.Collections;

//https://www.interviewbit.com/problems/noble-integer/
public class NobleInteger {
    public int solve(ArrayList<Integer> A) {
        // Total runtime: O(n log n) due to sort
        Collections.sort(A);
        for (int i = 0; i < A.size(); i++) {
            // Handle duplicates (only check for rightmost duplicate), skip others
            if (i < A.size() - 1 && A.get(i) == A.get(i + 1)) {
                continue;
            }
            // Check if the remaining values to the right are equal to the current value
            if (A.size() - i - 1 == A.get(i)) {
                return 1;
            }
        }
        return -1;
    }

    public int solve2(ArrayList<Integer> A) {
        Collections.sort(A);
        Collections.reverse(A);
        int l =A.size();
        for(int i=0; i<l ;i++){
            if(A.get(i)==i){
                if(i!=0 && A.get(i)!=A.get(i-1)){
                    //System.out.println(i);
                    return 1;
                }
                else if(i==0){
                    return 1;
                }
            }
        }
        return -1;
    }
}
