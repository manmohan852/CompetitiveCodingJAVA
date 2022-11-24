package site.gfg.bits;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryStringsOfAPattern {

    public static void print2(char str[], int index) {
        if (index == str.length) {
            System.out.println(str);
            return;
        }

        if (str[index] == '?') {
            str[index] = '0';
            print2(str, index + 1);
            str[index] = '1';
            print2(str, index + 1);
            str[index] = '?';
        } else
            print2(str, index + 1);
    }

    public static void print1(char str[]) {
        String st = str.toString();
        Queue<String> queue = new LinkedList<>();
        queue.add(st);

        while(!queue.isEmpty()){
            String temp = queue.poll();
            int index = temp.indexOf('?');
            if(index != -1){
                char[] tempArray = temp.toCharArray();
                tempArray[index] = '0';
                queue.add(tempArray.toString());
                tempArray[index] = '1';
                queue.add(tempArray.toString());
            }else{
                System.out.println(temp);
            }
        }

    }



    public static void main(String[] args) {
        String input = "1??0?101";
        char[] str = input.toCharArray();
        print2(str, 0);
    }

}

