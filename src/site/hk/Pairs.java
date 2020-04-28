package site.hk;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pairs {

    static int pairs(int k, int[] arr) {
        Set<Integer> javaset = new HashSet<>();
        List<List<Integer>> al  =  new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            javaset.add(arr[i]);
        }
        int count = 0;
        for(Integer ii : javaset){
            if(javaset.contains(ii + k)){
                count++;
            }
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] =1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;

        pairs(2,arr);

    }
}
