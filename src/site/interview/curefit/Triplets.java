package site.interview.curefit;

import java.util.ArrayList;
import java.util.TreeSet;
//TODO
public class Triplets {

    public static int solve(ArrayList<Integer> A) {
        TreeSet<Integer> tree = new TreeSet();
        int n = A.size();
        int[] rightMax = new int[n];
        rightMax[n - 1] = A.get(n - 1);
        for(int i = n - 2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i + 1], A.get(i));
        }
        int ans = 0;
        tree.add(A.get(0));
        for(int i = 1; i < n - 1; i++){
            int temp = tree.lower(A.get(i)) != null ? tree.lower(A.get(i)) : 0 ;
            if(rightMax[i + 1] > A.get(i)){
                ans = Math.max(ans, A.get(i) + temp + rightMax[i + 1]);
            }
            tree.add(A.get(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(3);
        arr.add(9);
        arr.add(4);
        arr.add(2);
        arr.add(8);
        solve(arr);
    }
}