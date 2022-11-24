package site.leetcode.DP;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/edit-distance/
//https://www.geeksforgeeks.org/edit-distance-dp-5/
//72. Edit Distance
public class EditDistance {

    //Time Complexity: O(m*n)
    //Space Complexity: O(m*n)
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] cost = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            cost[i][0] = i;
        for (int i = 1; i <= n; i++)
            cost[0][i] = i;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j))
                    cost[i + 1][j + 1] = cost[i][j];
                else {
                    int a = cost[i][j];
                    int b = cost[i][j + 1];
                    int c = cost[i + 1][j];
                    cost[i + 1][j + 1] = a < b ? (a < c ? a : c) : (b < c ? b : c);
                    cost[i + 1][j + 1]++;
                }
            }
        }
        return cost[m][n];
    }

    //Time Complexity: O(3^m)
    static int minDistance2(String str1, String str2, int m, int n) {
        if (m == 0)
            return n;
        if (n == 0)
            return m;
        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return minDistance2(str1, str2, m - 1, n - 1);
        return 1 + Math.min(Math.min(minDistance2(str1, str2, m, n - 1), // Insert
                minDistance2(str1, str2, m - 1, n)), // Remove
                minDistance2(str1, str2, m - 1, n - 1));//replace
    }


    public static int minDistance3(String word1, String word2){
        Map<String,Integer> mem = new HashMap<>();
        return minDistance3Util(word1,word2,word1.length(),word2.length(),mem);

    }

    //Time Complexity: O(3^m)
    static int minDistance3Util(String str1, String str2, int m, int n, Map<String, Integer> mem) {
        String key = String.format("%d#%d", m, n);
        if(mem.containsKey(key)){
            return mem.get(key);
        }
        if (m == 0) {
            mem.put(key,n);
            return n;
        }
        if (n == 0) {
            mem.put(key,m);
            return m;
        }

        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            key = String.format("%d#%d", m - 1, n-1);
            if(mem.containsKey(key)){
                return mem.get(key);
            }else{
                int val =  minDistance3Util(str1, str2, m - 1, n - 1,mem);
                mem.put( key,val);
                return val;
            }
        }
        int x = minDistance3Util(str1, str2, m, n - 1,mem);// Insert
        key = String.format("%d#%d", m, n-1);
        mem.put(key,x);
        int y = minDistance3Util(str1, str2, m - 1, n,mem);// Remove
        key = String.format("%d#%d", m-1, n);
        mem.put(key,y);
        int z = minDistance3Util(str1, str2, m - 1, n - 1,mem);//replace
        key = String.format("%d#%d", m-1, n-1);
        mem.put(key,z);
        int ans = 1 + Math.min(Math.min(x,y),z);
        mem.put(key,ans);
        return ans;
    }

    public static void main(String args[]) {
        String str1 = "sunday";
        String str2 = "saturday";
        minDistance3(str1, str2);
    }
}
