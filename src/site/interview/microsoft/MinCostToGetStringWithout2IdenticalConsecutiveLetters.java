package site.interview.microsoft;
//https://leetcode.com/discuss/interview-question/558379/
public class MinCostToGetStringWithout2IdenticalConsecutiveLetters {

    public static void main(String[] args) {
        String s1 = "ab";
        int[] nums1 = {1,3};
        String s2 = "abccbd";
        int[] nums2 = {0,1,2,3,4,5};
        String s3 = "aabbcc";
        int[] nums3 = {1,2,1,2,1,2};
        String s4 = "aaaa";
        int[] nums4 = {3,4,5,6};
        String s5 = "ababa";
        int[] nums5 = {10,5,10,5,10};
        System.out.println(getMinCost(s1, nums1));
        System.out.println(getMinCost(s2, nums2));
        System.out.println(getMinCost(s3, nums3));
        System.out.println(getMinCost(s4, nums4));
        System.out.println(getMinCost(s5, nums5));
    }

    private static int getMinCost(String s, int[] nums) {
        int res = 0;
        int sum = nums[0], max = nums[0];
        for(int i=1;i<s.length();i++) {
            if(s.charAt(i) != s.charAt(i-1)) {
                res += sum - max;
                sum = nums[i];
                max = nums[i];
            }else {
                sum += nums[i];
                max = Math.max(max, nums[i]);
            }
        }
        res += sum - max;
        return res;
    }
}
