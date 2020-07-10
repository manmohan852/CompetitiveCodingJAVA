package site.interview.airtelAfrica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Question: A string S of lowercase English letters is given. We want to partition this string into as many parts as
//possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
// a character cannot be present in two parts, if it exusts in multiple places, it should in a single part.
//letters :
//l
//ette
//r
//s
//Algo: we store all the first  and last occurence for every character in a pre array,
//then we combine all overlapping intervals, if intervals dont overlap then update its length in answer.
//https://leetcode.com/articles/partition-labels/
public class PartitionString {

    public static List<Integer> partition(String str) {
        int n = str.length();
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> pre = new ArrayList<>();
        int charList[] = new int[26];
        for (int i = 0; i < n; i++) {
            int i1 = str.charAt(i) - 'a';
            charList[i1] = charList[i1] + 1;
            if (charList[i1] < 2) {
                int j = str.lastIndexOf(str.charAt(i));
                pre.add(Arrays.asList(i, j));
            }
        }
        int m = pre.size();
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if (pre.get(j).get(0) < pre.get(j - 1).get(1)) {
                    pre.get(j).set(0, pre.get(j - 1).get(0));
                    pre.get(j).set(1, Math.max(pre.get(j).get(1), pre.get(j - 1).get(1)));
                } else {
                    //control would never comes here at last index
                    i = j - 1;
                    int len = pre.get(i).get(1) - pre.get(i).get(0) + 1;
                    result.add(len);
                    break;
                }
            }
            if(i==m-1){
                int len = pre.get(i).get(1) - pre.get(i).get(0) + 1;
                result.add(len);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "ababcbacadefegdehijhklij";
        String str2 = "letters";
        partition(str2);
    }
}
