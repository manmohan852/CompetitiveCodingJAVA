package site.gfg.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//https://www.geeksforgeeks.org/word-ladder-length-of-shortest-chain-to-reach-a-target-word/?ref=rp
//BFS
public class WordLadder1 {
    //Time Complexity is O(n²m) where n is the number of entries originally in the dictionary
    // and m is the size of the string
    static int shortestChainLen(String start, String target, Set<String> D) {
        if (!D.contains(target))
            return 0;
        int level = 0, wordlength = start.length();
        Queue<String> Q = new LinkedList<>();
        Q.add(start);
        while (!Q.isEmpty()) {
            ++level;
            int sizeofQ = Q.size();
            for (int i = 0; i < sizeofQ; ++i) {
                char[] word = Q.peek().toCharArray();
                Q.remove();
                for (int pos = 0; pos < wordlength; ++pos) {
                    char orig_char = word[pos];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        word[pos] = c;
                        if (String.valueOf(word).equals(target))
                            return level + 1;
                        if (!D.contains(String.valueOf(word)))
                            continue;
                        D.remove(String.valueOf(word));
                        Q.add(String.valueOf(word));
                    }
                    word[pos] = orig_char;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Set<String> D = new HashSet<>();
        D.add("poon");
        D.add("plee");
        D.add("same");
        D.add("poie");
        D.add("plie");
        D.add("poin");
        D.add("plea");
        String start = "toon";
        String target = "plea";
        System.out.print("Length of shortest chain is: " + shortestChainLen(start, target, D));
    }
}

