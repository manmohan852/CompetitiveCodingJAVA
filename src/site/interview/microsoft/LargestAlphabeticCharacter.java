package site.interview.microsoft;

public class LargestAlphabeticCharacter {

    public static void main(String[] args) {
        System.out.println(largestCharacter("admeDCAB"));
    }

    //Time Complexity: O(n), n is the length of the input string
    //Space Complexity: O(26)
    public static String largestCharacter(String s) {
        // record each char's uppercase or lowercase
        boolean[] uppers = new boolean[26];
        boolean[] lowers = new boolean[26];
        char[] arr = s.toCharArray();
        for (char cur : arr) {
            if (Character.isLowerCase(cur)) lowers[cur - 'a'] = true;
            if (Character.isUpperCase(cur)) uppers[cur - 'A'] = true;
        }
        // visit from uppercase's high index
        for (int i = 25; i >= 0; i--) {
            // check both its uppercase and lowercase exist or not
            if (uppers[i] && lowers[i]) {
                return (char) (i + 'A') + "";
            }
        }
        return "NO";
    }
}
