package MySite.LeetCode.Array;

import java.util.HashSet;

public class containsDuplicate {
    public static void main(String[] args) {

    }
    public boolean containsDuplicate(int[] nums) {
        if(nums==null || nums.length==0) return false;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                return true;
            }
            else set.add(nums[i]);
        }
        return false;
    }

}
