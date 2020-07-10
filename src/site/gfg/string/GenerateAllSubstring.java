package site.gfg.string;
//https://www.geeksforgeeks.org/program-print-substrings-given-string/
public class GenerateAllSubstring {

//    Count of non-empty substrings is n*(n+1)/2
//    If we include empty string also as substring, the count becomes n*(n+1)/2 + 1
    static void subString(String str, int n) {
        for (int i = 0; i < n; i++){
            for (int j = i+1; j <= n; j++) {
                System.out.print(str.substring(i, j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        subString(str, str.length());
    }
}