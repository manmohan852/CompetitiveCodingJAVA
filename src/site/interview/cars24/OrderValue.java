package site.interview.cars24;

import java.util.*;

public class OrderValue {
    public static void main(String[] args) {
        Map<String,Integer> names = new HashMap<>();
        names.put("Anne",10);
        names.put("John",35);
        names.put("Bob",2);
        Set<Map.Entry<String,Integer>> set = names.entrySet();
        List<Map.Entry<String,Integer>> list = new ArrayList<>(set);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> stringIntegerEntry, Map.Entry<String, Integer> t1) {
                return (t1.getValue()).compareTo(stringIntegerEntry.getValue());
            }
        });
        for (Map.Entry<String,Integer> entry : list){
            System.out.println("" + entry.getKey());
        }

    }
}
