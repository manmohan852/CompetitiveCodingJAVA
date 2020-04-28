package site.ibit;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EqualSubstrings {
    public static void main(String[] args) {
        String str = "0102010012012012";
        System.out.println(getSubstringWithEqual012(str));
        String str2 = "110101010";
        String str3 = "211122";
        System.out.println(getSubstringWithEqual012(str3));
    }

    private static Integer getSubstringWithEqual01(String str) {
        int n = str.length();
        Map<Integer,Integer> pairMap = new HashMap<>();
        pairMap.put(0,-1); //diff vs index
        int zc = 0;
        int oc = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '0') zc++;
            else if (str.charAt(i) == '1') oc++;
            Integer val = pairMap.get(zc - oc);
            if(val == null) val = 0;
            res = res + val;
            pairMap.put(zc-oc, val + 1);
        }
        return res;
    }

    private static int getSubstringWithEqual012(String str) {
        int n = str.length();
        Map<Map.Entry<Integer, Integer>, Integer> pairMap = new HashMap<>();
        pairMap.put(Pair.of(0, 0), 1);
        int zc = 0;
        int oc = 0;
        int tc = 0;

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '0') zc++;
            else if (str.charAt(i) == '1') oc++;
            else tc++;
            Integer val = pairMap.get(Pair.of(zc - oc, zc - tc));
            if(val == null) val = 0;
            res = res + val;
            pairMap.put(Pair.of(zc - oc, zc - tc), val + 1);
        }
        return res;
    }

    static class Pair {
        static public <T, U> Map.Entry<T, U> of(T first, U second) {
            return new AbstractMap.SimpleEntry<>(first, second);
        }
    }

}
