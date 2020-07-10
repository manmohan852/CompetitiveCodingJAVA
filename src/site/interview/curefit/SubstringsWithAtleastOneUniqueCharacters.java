package site.interview.curefit;

public class SubstringsWithAtleastOneUniqueCharacters {
    //every substrings should have atleast one character whose count is 1 only,has no dulplicates in that substrings
    //if all substrings are unique- we can call the string as good string
    // else its a bas string

    //TODO

    public static boolean checkUniqueSubstrings(String str){
return false;
    }

    public static void main(String[] args) {
        String s1 = "aaba";//bad string
        String s2 = "aba"; // good string
        String s3 = "abab";
        checkUniqueSubstrings(s2);
    }
}
