package ericProgramming.String;

import java.util.*;

public class groupAnagrams {
    public static void main(String[] args) {

    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<String, Integer> map = new HashMap<String,Integer>();
        int pos = 0;
        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if(!map.containsKey(key)){
                map.put(key, pos++);
                List<String> list = new ArrayList<String>();
                list.add(s);
                res.add(list);
            }
            else{
                res.get(map.get(key)).add(s);
            }

        }
        return res;
    }
}
