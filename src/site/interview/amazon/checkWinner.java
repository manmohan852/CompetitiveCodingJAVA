package site.interview.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class checkWinner {
    public static void main(String[] args) {
        List<List<String>> codeList = new ArrayList<>();
        List<String> code1 = new ArrayList<>(Arrays.asList("apple","apple"));
        List<String> code2 = new ArrayList<>(Arrays.asList("banana","anything","banana"));
        codeList.add(code1);
        codeList.add(code2);
        List<String> shoppingCart = new ArrayList<>(Arrays.asList("apple","apple","orange","orange","banana","apple","banana","banana"));
        checkWinner(codeList,shoppingCart);

        List<List<String>> codeList2 = new ArrayList<>();
        List<String> code10 = new ArrayList<>(Arrays.asList("orange"));
        List<String> code11 = new ArrayList<>(Arrays.asList("apple","apple"));
        List<String> code12 = new ArrayList<>(Arrays.asList("banana","orange","apple"));
        codeList2.add(code10);
        codeList2.add(code11);
        codeList2.add(code12);
        List<String> shoppingCart2 = new ArrayList<>(Arrays.asList("orange","apple","apple","banana","orange","apple","banana"));
        checkWinner(codeList2,shoppingCart2);

        List<List<String>> codeList23 = new ArrayList<>();
        List<String> code20 = new ArrayList<>(Arrays.asList("apple","apricot"));
        List<String> code21 = new ArrayList<>(Arrays.asList("banana","anything","guava"));
        List<String> code22 = new ArrayList<>(Arrays.asList("papaya","anything"));
        codeList23.add(code20);
        codeList23.add(code21);
        codeList23.add(code22);
        List<String> shoppingCart3 = new ArrayList<>(Arrays.asList("banana","orange","guava","apple","apricot","papaya","kiwi"));
        checkWinner(codeList23,shoppingCart3);
        System.out.println();
    }

    public static int checkWinner(List<List<String>> codeList, List<String> shoppingCart) {
        for (List<String> code : codeList) {
            int k  = isSubArrayString(shoppingCart,code,shoppingCart.size(),code.size());
            if(k == -1){
                return 0;
            }else{
                shoppingCart = shoppingCart.subList(k,shoppingCart.size());
            }
        }
        return 1;
    }

    static int isSubArrayString(List<String> A, List<String> B, int n, int m) {
        try {
            int i = 0, j = 0;
            String temp = "anything";
            while (i < n && j < m) {
                if (temp.equals(B.get(j)) || A.get(i).equals(B.get(j))) {
                    i++;
                    j++;
                    if (j == m)
                        return i;
                } else {
                    i = i - j + 1;
                    j = 0;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    static int isSubArray(int A[], int B[], int n, int m) {
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (A[i] == B[j]) {
                i++;
                j++;
                if (j == m)
                    return j;
            }
            else {
                i = i - j + 1;
                j = 0;
            }
        }
        return -1;
    }
}
