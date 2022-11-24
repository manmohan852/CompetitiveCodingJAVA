package site.interview.curefit;

public class SubstringsWithAtleastOneUniqueCharacters {
    //every substrings should have atleast one character whose count is 1 only,has no dulplicates in that substrings
    //if all substrings are unique- we can call the string as good string
    // else its a bad string

    //TODO

    public static boolean checkUniqueSubstrings2(String s) {

        return true;
    }

    //Brute force
    //Time complexity : O(n^3)
    //Space complexity :O(min(m,n)).,, m is the no of distinct characters in the string
    public static boolean checkUniqueSubstrings(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (!checkSubstring(s, i, j)){
                    return false;
                }
        return true;
    }

    public static boolean checkSubstring(String s, int start, int end) {
        int[] count = new int[26];
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            count[ch - 'a'] += 1;
        }
        for (int i = 0; i < 26; i++) {
            if(count[i] == 1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "aaba";//bad string
        String s2 = "aba"; // good string
        String s3 = "abab";
        boolean res = checkUniqueSubstrings(s1);
        if(res){
            System.out.println("Good String");
        }else{
            System.out.println("Bad String");
        }
    }
}
