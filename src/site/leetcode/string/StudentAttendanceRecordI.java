package site.leetcode.string;

public class StudentAttendanceRecordI {

    //Time complexity : O(n)
    public static boolean checkRecord(String s) {
        int countA = 0;
        char[] arr = s.toUpperCase().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            //morethanone A
            //more than 2continous L
            if(arr[i] == 'A'){
                countA++;
            }
            if(countA > 1){
                return false;
            }
            if(arr[i] == 'L'){
                int countL = 0;
                while(i < arr.length && arr[i] == 'L'){
                    countL++;
                    i++;
                    if(countL > 2){
                        return false;
                    }
                }
                i--;
            }
        }
        return true;
    }

    //Time complexity : O(n),Single loop and indexOf method takes O(n) time.
    public boolean checkRecord2(String s) {
        int count=0;
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)=='A')
                count++;
        return count<2 && s.indexOf("LLL")<0;
    }

    public boolean checkRecord3(String s) {
        int count=0;
        for(int i=0;i<s.length() && count<2 ;i++)
            if(s.charAt(i)=='A')
                count++;
        return count<2 && s.indexOf("LLL")<0;
    }

    public boolean checkRecord4(String s) {
        int countA = 0;
        for (int i = 0; i < s.length() && countA < 2; i++) {
            if (s.charAt(i) == 'A')
                countA++;
            if (i <= s.length() - 3 && s.charAt(i) == 'L' && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L')
                return false;
        }
        return countA < 2;
    }

    public static void main(String[] args) {
        String str = "PPALLP";
        String str2 = "PPALLL";
        String str3 = "ALL";
        checkRecord(str3);
    }

}
