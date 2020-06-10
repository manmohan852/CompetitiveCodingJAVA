package site.interview.techmojo;

public class test2 {
    public static void main(String[] args) {
        String ss = "xyz abc mnp \"asdf dfaa asdf\" asd \"fdas asdsdafF\"";
        tokenizeString(ss);
    }

    public static void tokenizeString(String str) {
        int n = str.length();
        String res = "";
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '"') {
                res = str.charAt(i) + "";
                int j = i+1;
                for (; j < n; j++) {
                    res += str.charAt(j);
                    if (str.charAt(j) == '"') {
                        System.out.println(res);
                        res = "";
                        break;
                    }
                }
                i = j+1;
            } else if (str.charAt(i) == ' ') {
                System.out.println(res);
                res = "";
            } else
                res += str.charAt(i);
        }
    }
}
