package site.leetcode.string;

import java.util.*;

//https://leetcode.com/problems/concatenated-words/
public class ConcatenatedWords {

    Map<String, Boolean> cache;


    //Space Complexity : O(n) for the set
    //Time Complexity: O(nk^2)
    //Let K be the length of the longest string then there could be roughly K^2 substring comparisons.
    //This would be done for all n strings.
    //Giving an upper bound of O(nk^2).
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new LinkedList<>();
        if (words == null || words.length == 0) return result;
        cache = new HashMap<>();
        Set<String> availableWords = new HashSet<>();
        for (String word : words) {
            availableWords.add(word);
        }
        for (String word : words) {
            availableWords.remove(word);
            if (canBreak(word, availableWords)) {
                result.add(word);
            }
            availableWords.add(word);
        }
        return result;
    }

    private boolean canBreak(String word, Set<String> availableWords) {
        if (availableWords.size() == 0) return false;
        if (word == null || word.length() == 0) return false;
        if (cache.containsKey(word)) return cache.get(word);
        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);
            if (availableWords.contains(prefix) && (availableWords.contains(suffix) || canBreak(suffix, availableWords))) {
                cache.put(word, true);
                return true;
            }
        }
        cache.put(word, false);
        return false;
    }

}
