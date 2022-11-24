package site.interview.microsoft;

import java.util.PriorityQueue;

//https://leetcode.com/problems/bulb-switcher-iii/
public class BulbSwitcherIII {

    public static int numTimesAllBlue1(int[] arr) {
        int ans = 0, sum = 0, target = 0;

        for(int i = 1; i<= arr.length; i++) {
            sum += arr[i-1];
            target += i ; //Sum from 1 to i
            if(sum == target) ans++;
        }

        return ans;
    }

    public static int numTimesAllBlue2(int[] light) {
        int count=0;
        PriorityQueue<Integer> q=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<light.length;i++){
            q.offer(light[i]);
            if(q.size()==q.peek()){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 3, 5, 4};
        numTimesAllBlue1(A);
    }
}
