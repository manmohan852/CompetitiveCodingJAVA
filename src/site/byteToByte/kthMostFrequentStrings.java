package site.byteToByte;

import java.util.*;

public class kthMostFrequentStrings {
    //ques 51
    public static String kthMostFrequent(String[] strings, int k) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for (String s : strings) {
            Integer x = map.get(s);
            if (x == null) x = 0;
            map.put(s, ++x);
        }

        List list = new ArrayList(map.entrySet());

        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                Integer v1 = (Integer) ((Map.Entry) o1).getValue();
                Integer v2 = (Integer) ((Map.Entry) o2).getValue();
                return v1.compareTo(v2);
            }
        });

        if (list.size() > k) {
            Map.Entry<String, Integer> s = (Map.Entry<String, Integer>)list.get(k);
            return s.getKey();
        }
        return null;
    }

    public static void main(String[] args) {
        int n = 6;
        String[] list = new String[n];
        list[0] = "a";
        list[1] = "b";
        list[2] = "c";
        list[3] = "a";
        list[4] = "b";
        list[5] = "a";
        int k = 1;
        kthMostFrequent(list, k);
    }
}
