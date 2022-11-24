package site.interview.gsachs;

public class MaximalCommonality {
    public static int findMaximalCommanlity(String st) {
        char[] str = st.toCharArray();
        if (str.length < 2)
            return 0;
        int maxMatch = 0, match = 0, n = str.length;
        int[] Lt = new int[26];
        int[] Rt = new int[26];
        //for Lt ---  str[0]
        Lt[str[0] - 'a']++;
        //for Rt ---  str[1]:str[n-1]
        for (int i = n - 1; i >= 1; i--) {
            Rt[str[i] - 'a']++;
            if (Lt[str[i] - 'a'] == 1) {
                match = 1;
                maxMatch = 1;
            }
        }

        for (int i = 1; i <= n - 2; i++) {
            if (Lt[str[i] - 'a'] == Rt[str[i] - 'a']) {
                match--;
            } else if (Lt[str[i] - 'a'] > Rt[str[i] - 'a']) {
                match--;
            } else {
                if (!(Lt[str[i] - 'a'] == 0 && Rt[str[i] - 'a'] == 1)) {
                    match++;
                    if (match > maxMatch)
                        maxMatch = match;
                }
            }
            Lt[str[i] - 'a']++;
            Rt[str[i] - 'a']--;
        }
        return maxMatch;
    }

    public static void main(String[] args) {
        //string str = "abcdecdefg"; // ans = 3
        String str = "aabbbbaa"; // ans = 4
        System.out.println(findMaximalCommanlity(str));
    }
}