package site.gfg.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/word-ladder-set-2-bi-directional-bfs/?ref=rp
//half the time as compared to the standard BFS approach.
//https://www.geeksforgeeks.org/bidirectional-search/?ref=rp
public class WordLadder2 {

    public static class node {
        String word;
        int len;
        public node(String word, int len) {
            this.word = word;
            this.len = len;
        }
    }

    public static boolean isAdj(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                count++;
        }
        if (count == 1)
            return true;
        return false;
    }

    public static int ladderLength(String beginWord, String endWord, ArrayList<String> wordList) {
        Queue<node> q1 = new LinkedList<>();
        Queue<node> q2 = new LinkedList<>();
        HashMap<String, Integer> vis1 = new HashMap<>();
        HashMap<String, Integer> vis2 = new HashMap<>();

        node start = new node(beginWord, 1);
        node end = new node(endWord, 1);

        vis1.put(beginWord, 1);
        q1.add(start);
        vis2.put(endWord, 1);
        q2.add(end);

        while (q1.size() > 0 && q2.size() > 0) {
            node curr1 = q1.remove();
            node curr2 = q2.remove();
            for (int i = 0; i < wordList.size(); i++) {
                if (isAdj(curr1.word, wordList.get(i)) && vis1.containsKey(wordList.get(i)) == false) {
                    node temp = new node(wordList.get(i), curr1.len + 1);
                    q1.add(temp);
                    vis1.put(wordList.get(i), curr1.len + 1);
                    if (temp.word.equals(endWord)) {
                        return temp.len;
                    }
                    if (vis2.containsKey(temp.word)) {
                        return temp.len + vis2.get(temp.word) - 1;
                    }
                }
            }
            for (int i = 0; i < wordList.size(); i++) {
                if (isAdj(curr2.word, wordList.get(i)) && vis2.containsKey(wordList.get(i)) == false) {
                    node temp = new node(wordList.get(i),
                            curr2.len + 1);
                    q2.add(temp);
                    vis2.put(wordList.get(i), curr2.len + 1);
                    if (temp.word.equals(beginWord)) {
                        return temp.len;
                    }
                    if (vis1.containsKey(temp.word)) {
                        return temp.len + vis1.get(temp.word) - 1;
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String args[]) {
        ArrayList<String> wordList = new ArrayList<>();
        wordList.add("poon");
        wordList.add("plee");
        wordList.add("same");
        wordList.add("poie");
        wordList.add("plie");
        wordList.add("poin");
        wordList.add("plea");

        String start = "toon";
        String target = "plea";

        System.out.println(ladderLength(start, target, wordList));
    }
}

