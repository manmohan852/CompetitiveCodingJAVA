package site.leetcode.array;

public class ProductExceptSelf {

    //    Time complexity : O(N) & Space complexity : O(1)
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;
        for(int i=1;i<len;i++){
            res[i] = nums[i-1] * res[i-1];
        }
        int right = 1;
        for(int i=len-1;i>=0;i--){
            res[i] = res[i] * right;
            right = right * nums[i];
        }
        return res;
    }

//    Time complexity : O(N) & Space complexity : O(N)
    public static int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int[] L = new int[len];
        int[] R = new int[len];

        L[0] = 1;
        for(int i=1;i<len;i++){
            L[i] = nums[i-1] * L[i-1];
        }
        R[len-1] = 1;
        for(int i=len-2;i>=0;i--){
            R[i] = R[i+1] * nums[i+1];
        }
        for (int i=0;i<len;i++){
            res[i] = L[i] * R[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] res = productExceptSelf2(nums);
        for (int i =0;i<res.length;i++) {
            System.out.print(res[i] + " ");
        }
    }
}
