package site.leetcode.string;

import java.util.*;
import java.util.stream.Collectors;

//https://leetcode.com/problems/most-common-word/
//819. Most Common Word
public class MostCommonWord {

    public static String mostCommonWord1(String paragraph, String[] banned) {
        String[] words = paragraph.split("\\P{Alpha}+"); // no empty string present
//        String[] words = paragraph.split("\\W");//empty string also present
        HashSet<String> banSet = new HashSet();
        for (String s : banned) {
            banSet.add(s);
        }
        Map<String, Integer> countOccurance = new HashMap<>();

        for (String word : words) {
            countOccurance.put(word.toLowerCase(), countOccurance.getOrDefault(word.toLowerCase(), 0) + 1);
        }
        int max = 0;
        String finalWord = "";
        for (String key : countOccurance.keySet()) {
            if (countOccurance.get(key) > max && !banSet.contains(key)) {
                finalWord = key;
                max = countOccurance.get(key);
            }
        }
        return finalWord;
    }

    public String mostCommonWord2(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> bannedSet = new HashSet<>();
        bannedSet.addAll(Arrays.asList(banned));
        String[] words = paragraph.split("\\W");

        for (String word : words) {
            word = word.toLowerCase();
            if (word.isEmpty() || bannedSet.contains(word))
                continue;

            int previous = map.getOrDefault(word, 0);
            map.put(word, previous + 1);
        }
        System.out.println(map);
        return map
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry<String, Integer>::getValue))
                .orElseThrow(IllegalArgumentException::new)
                .getKey();
    }

    public String mostCommonWord3(String paragraph, String[] banned) {
        List<String> banList = Arrays.asList(banned);
        return Arrays.stream(paragraph.toLowerCase().split("\\W")) //stream of strings
                .filter(s -> !s.isEmpty() && !banList.contains(s)) //just use non-empty strings and strings not contained in banList
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))//group strings by count, this will return a map string,count
                .entrySet()//get entrySet
                .stream()//get stream of entrySet
                .max(Comparator.comparingLong(Map.Entry::getValue))//get max entry comparing by value i.e. count
                .get().getKey();//get key i.e. string
    }


    public String mostCommonWord4(String paragraph, String[] banned) {
        List<String> words = mySplit(paragraph);
        Set setBannded = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();
        int max = Integer.MIN_VALUE;
        String maxWord = "";
        for (String word : words) {
            String temp = word;
            if (!setBannded.contains(temp)) {
                count.put(temp, count.getOrDefault(temp, 0) + 1);
                if (count.get(temp) > max) {
                    max = count.get(temp);
                    maxWord = temp;
                }
            }
        }
        return maxWord;
    }

    private List<String> mySplit(String s) {
        StringBuilder sb = null;
        List<String> words = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                if (sb == null) sb = new StringBuilder();
                sb.append(Character.toLowerCase(s.charAt(i)));
            } else {
                if (sb != null) {
                    words.add(sb.toString());
                }
                sb = null;
            }
        }
        if (sb != null) words.add(sb.toString());
        return words;
    }

    public static void main(String[] args) {
        String para = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = new String[1];
        banned[0] = "hit";
        System.out.println(mostCommonWord1(para, banned));
    }
}
