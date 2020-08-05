package site.interview.microsoft;
//https://leetcode.com/discuss/interview-question/578315/
public class Riddle {

    //Java solution O(n)/O(1): Basic ideal is to check pre/post char if current char is ?. After that pick up a new char from 'a' to 'z'
    public String replaceQuestionMark(String str){
        if(str.length()==0){
            return str;
        }
        char[] arr = str.toCharArray();
        for(int i=0; i<arr.length; i++){
            if(arr[i]=='?'){
                char pre = '?';
                char post = '?';
                if(i>0){
                    pre = arr[i-1];
                }
                if(i<arr.length-1){
                    post = arr[i+1];
                }
                char rep = 'a';
                while((rep==pre || rep==post)&& rep<='z'){
                    rep = (char)(rep+1);
                }
                arr[i] = rep;
            }
        }
        return new String(arr);
    }

    //Method 2
    //O(N)
    //Since we need to check just the previous and the next characters, we can fulfil any pattern using maximum 3 characters.
    //We just need to check if both previous and next characters are different from 'a', 'b' or 'c'
    // and put the one which satisfy the condition.
    public static String solution(String str) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == '?') {
                for (char c = 'a'; c < 'd'; ++c) {
                    if ((i == 0 || c != arr[i-1]) && (i == arr.length - 1 || c != arr[i+1])) {
                        arr[i] = c;
                        break;
                    }
                }
            }
        }
        return new String(arr);
    }

}
