package site.interview.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/search-suggestions-system/
public class SearchSuggestionsSystem {

    class Trie {
        List<String> word;
        Trie[] children;
        public Trie() {
            word = new ArrayList<>();
            children = new Trie[26];
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = new Trie();

        //build Trie
        for(String w: products) {
            Trie node = root;
            for(char c: w.toCharArray()) {
                if(node.children[c-'a'] == null)
                    node.children[c-'a'] = new Trie();
                node = node.children[c-'a'];
                node.word.add(w);
            }
        }

        List<List<String>> res = new ArrayList<>();
        Trie dummy = root;

        for(int i = 0; i < searchWord.length(); i++)
            res.add(new ArrayList<>());

        for(int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            if(dummy != null && dummy.children[c-'a'] != null) {
                List<String> list = dummy.children[c-'a'].word;
                Collections.sort(list);
                for(int k = 0; k < Math.min(3, list.size()); k++)
                    res.get(i).add(list.get(k));
            }
            if(dummy != null)
                dummy = dummy.children[c-'a'];
        }
        return res;
    }
}
