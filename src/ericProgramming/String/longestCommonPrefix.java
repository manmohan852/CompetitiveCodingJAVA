package ericProgramming.String;

public class longestCommonPrefix {
    public static void main(String[] args) {

    }
    public String longestCommonPrefix(String[] strs) {
        String common = "";
        if(strs.length == 0) return common;
        common = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(common) != 0){
                common = common.substring(0, common.length() - 1);
                // System.out.print(common + "  i = "  + i);
            }

        }
        return common;
    }
}
