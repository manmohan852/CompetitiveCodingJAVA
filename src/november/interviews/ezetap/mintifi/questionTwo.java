package november.interviews.ezetap.mintifi;

import java.util.HashSet;
import java.util.Set;

public class questionTwo {
    public static void main(String[] args) {
        String str = "Java is great Python is    also great";
        String[] s= str.split(" ");
        Set<String> hs = new HashSet<>();
        for(int i = 0; i < s.length; i++){
            hs.add(s[i]);
        }
        System.out.println(hs);
    }
}
