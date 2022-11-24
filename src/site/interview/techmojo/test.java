package site.interview.techmojo;

import java.util.Scanner;

public class test {
}
//Snake case of a given sentence
//https://www.geeksforgeeks.org/snake-case-given-sentence/
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        Integer t = s.nextInt();
        while(t>=0){
            String name = s.nextLine();
            StringBuilder str = new StringBuilder();
            for(int i=0;i<name.length();i++){
                if(i!= 0 && Character.isUpperCase(name.charAt(i))){
                    str.append("_");
                }
                str.append(Character.toLowerCase(name.charAt(i)));
            }
            System.out.println(str.toString());
            t--;
        }

    }
}
