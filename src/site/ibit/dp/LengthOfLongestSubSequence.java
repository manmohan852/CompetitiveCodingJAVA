package site.ibit.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://www.interviewbit.com/problems/length-of-longest-subsequence/
public class LengthOfLongestSubSequence {

    public static int longestSubsequenceLength(final List<Integer> A){
        List<Integer> lis1 = new ArrayList<>();
        List<Integer> lis2 = new ArrayList<>();

        if(A.size() == 0) return 0;

        int max = 0;

        for(int i=0; i<A.size(); i++){
            lis1.add(i,1);
            lis2.add(i,1);
        }

        for(int i= 1;i<A.size();i++){
            for(int j =0;j <i;j++){
                if(A.get(i) > A.get(j) && lis1.get(i) < lis1.get(j) + 1){
                    lis1.set(i,lis1.get(j) + 1);
                }
            }
        }

        for(int i= A.size()-2;i>=0;i--){
            for(int j = A.size() -1 ;j>i;j--){
                if(A.get(i) >  A.get(j) && lis2.get(i) < lis2.get(j) + 1){
                    lis2.set(i,lis2.get(j) + 1);
                }
            }
        }

        for(int i=0 ;i<A.size();i++){
            //System.out.println(max);
            if(max < (lis1.get(i) + lis2.get(i) - 1 )){
                max = lis1.get(i) + lis2.get(i) - 1;
            }
        }

        System.out.println(lis1);
        System.out.println(lis2);

        return max;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1, 11, 2, 10, 4, 5, 2, 1));
        System.out.println(longestSubsequenceLength(list));
    }
}
