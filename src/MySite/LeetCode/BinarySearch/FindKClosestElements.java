package MySite.LeetCode.BinarySearch;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/find-k-closest-elements/
public class FindKClosestElements {
    public static void main(String[] args) {

    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int l = 0, r = n - k;
        // here r = n - k because we are working on the window till n - k
        while(l < r){
            int mid = l + (r - l)/2;
            if( (x - arr[mid]) > (arr[mid + k] - x)){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        List<Integer> res = new LinkedList<>();
        for(int i = l; i < l + k; i++){
            res.add(arr[i]);
        }
        return res;
    }
}
