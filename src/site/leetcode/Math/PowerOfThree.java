package site.leetcode.Math;
//https://leetcode.com/problems/power-of-three/
public class PowerOfThree {

//    Time complexity : O(log3n). log base is 3
    public boolean isPowerOfThree(int n) {
        if(n==0) return false;
        while(n % 3 == 0){
            n = n / 3;
        }
        return n==1;
    }
}
