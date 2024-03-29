package MySite.LeetCode.TwoPointers;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/partition-labels/
public class partitionLabels {
    public static void main(String[] args) {

    }
    public List<Integer> partitionLabels(String s) {
        List<Integer> outputArray = new ArrayList<>();
        int n = s.length();
        int[] lastIndices = new int[26];
        for(int i = 0; i < n; i++){
            lastIndices[s.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;
        for(int i = 0; i < n; i++){
            end = Math.max(end, lastIndices[s.charAt(i) - 'a']);
            if(i == end){
                outputArray.add(end - start + 1);
                start = end + 1;
            }
        }
        return outputArray;
    }
}
