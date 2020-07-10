package site.ibit.dp;

//https://www.interviewbit.com/problems/ways-to-decode/
//https://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/
public class WaysToDecode {

    public static int numDecodings(String A){
        if(A==null || A.length() == 0)
            return 0;

        int[] count = new int[A.length() + 1];
        count[0] = 1;
        count[1] = 1;
        for(int j=2;j<=A.length();j++){
            count[j] = 0;
            if(A.charAt(j-1) > '0')
                count[j] = count[j-1];
            if(A.charAt(j-2) == '1' || A.charAt(j-2) == '2' && A.charAt(j-1) < '7'){
                count[j] +=count[j-2];
            }
        }
        return count[A.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
    }
}
