package site.interview.gsachs;

import java.util.HashMap;
import java.util.Map;

public class SharePurchases {

    public static void main(String[] args) {
        String s1 = "ABC";//ans = 1
        String s2 = "ABBCZBAC"; //ans = 13
        String s3 = "PQACBA"; //ans = 7
//        CountTimePeriodOnWhichTheseThreeSharesAreInvested(s2);
        analyzeInvestments(s2);

    }

    ////Time complexity: O(n^2)
    public static int CountTimePeriodOnWhichTheseThreeSharesAreInvested(String str) {
        int n = str.length();
        if (n < 3)
            return 0;
        int count = 0, s = 0, e = s; // sliding window 's' is start index 'e' is end index of the current window
        int a = 0, b = 0, c = 0; //counters of A,B,C shares respectively
        while (s <= n - 3 && e <= n - 1) {
            if (str.charAt(e) == 'A')
                a++;
            else if (str.charAt(e) == 'B')
                b++;
            else if (str.charAt(e) == 'C')
                c++;
            while (a > 0 && b > 0 && c > 0 && s <= n - 3 && e <= n - 1) {
                // suppose, [ABC]BCA  here total 4 possible combinations are ABC,ABCB, ABCBC, BACBCA. (n-e = 6-2=4)
                count += (n - e);
                s++;
                if (str.charAt(s - 1) == 'A')
                    a--;
                else if (str.charAt(s - 1) == 'B')
                    b--;
                else if (str.charAt(s - 1) == 'C')
                    c--;
            }
            e++;
        }
        return count;
    }

    //Time complexity: O(n^2)
    public static long analyzeInvestments(String s) {
        long ans = 0;
        for (int begin = 0; begin < s.length() - 2; begin++) {
            Map<Character, Integer> map = new HashMap<>();
            int end = begin;
            while (end < s.length()) {
                Character end_char = s.charAt(end);
                if (end_char == 'A' || end_char == 'B' || end_char == 'C') {
                    map.put(end_char, map.getOrDefault(end_char, 0) + 1);
                }
                // once you have at least one share from all the three given companies, you can add any character/share towards the end, and it would still satisfy the criteria.
                if (map.size() == 3) {
                    ans += (s.length() - end);
                    break;
                }
                end++;
            }
        }
        return ans;
    }
}
