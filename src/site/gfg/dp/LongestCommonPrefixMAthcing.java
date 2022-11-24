package site.gfg.dp;

import java.util.Arrays;

//https://www.geeksforgeeks.org/longest-common-prefix-matching-set-6/?ref=rp
public class LongestCommonPrefixMAthcing {
    static String commonPrefixUtil(String str1, String str2) {
        String result = "";
        int n1 = str1.length(), n2 = str2.length();
        for (int i = 0, j = 0; i <= n1 - 1 && j <= n2 - 1; i++, j++) {
            if (str1.charAt(i) != str2.charAt(j)) {
                break;
            }
            result += str1.charAt(i);
        }
        return (result);
    }

    static final int ALPHABET_SIZE = 26;

    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isLeaf;

        public TrieNode() {
            isLeaf = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }

    static TrieNode root;
    static int indexs;

    static void insert(String key) {
        int length = key.length();
        int index;
        TrieNode pCrawl = root;
        for (int level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();
            pCrawl = pCrawl.children[index];
        }
        pCrawl.isLeaf = true;
    }

    static int countChildren(TrieNode node) {
        int count = 0;
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (node.children[i] != null) {
                count++;
                indexs = i;
            }
        }
        return (count);
    }

    static String walkTrie() {
        TrieNode pCrawl = root;
        indexs = 0;
        String prefix = "";
        while (countChildren(pCrawl) == 1 &&
                pCrawl.isLeaf == false) {
            pCrawl = pCrawl.children[indexs];
            prefix += (char) ('a' + indexs);
        }
        return prefix;
    }

    static void constructTrie(String arr[], int n) {
        for (int i = 0; i < n; i++)
            insert(arr[i]);
        return;
    }

    static int findMinLength(String arr[], int n) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= (n - 1); i++) {
            if (arr[i].length() < min) {
                min = arr[i].length();
            }
        }
        return min;
    }

    static boolean allContainsPrefix(String arr[], int n, String str, int start, int end) {
        for (int i = 0; i <= (n - 1); i++) {
            String arr_i = arr[i];
            for (int j = start; j <= end; j++)
                if (arr_i.charAt(j) != str.charAt(j))
                    return false;
        }
        return true;
    }

    //Time Complexity: O(N * log N)
    static void commonPrefix1(String arr[], int n) {
        Arrays.sort(arr);
        System.out.println(commonPrefixUtil(arr[0], arr[n - 1]));
    }

    //    Inserting all the words in the trie takes O(MN) time and performing a walk on the trie takes O(M) time,
    static String commonPrefix2(String arr[], int n) {
        root = new TrieNode();
        constructTrie(arr, n);
        return walkTrie();
    }

    //O(NM log M),M is the length of the shortest string
    static String commonPrefix3(String arr[], int n) {
        int index = findMinLength(arr, n);
        String prefix = ""; // Our resultant string
        int low = 0, high = index - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (allContainsPrefix(arr, n, arr[0], low, mid)) {
                prefix = prefix + arr[0].substring(low, mid + 1);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return prefix;
    }

    //divide and conquerer ..time complexity is O(N M)
    static String commonPrefix4(String arr[], int low, int high) {
        if (low == high) {
            return (arr[low]);
        }
        if (high > low) {
            int mid = low + (high - low) / 2;
            String str1 = commonPrefix4(arr, low, mid);
            String str2 = commonPrefix4(arr, mid + 1, high);
            return (commonPrefixUtil(str1, str2));
        }
        return null;
    }

    //character matching,,,time complexity is O(N M)
    static String commonPrefix5(String arr[], int n) {
        int minlen = findMinLength(arr, n);
        String result = "";
        char current;
        for (int i = 0; i < minlen; i++) {
            current = arr[0].charAt(i);
            for (int j = 1; j < n; j++) {
                if (arr[j].charAt(i) != current) {
                    return result;
                }
            }
            result += (current);
        }
        return (result);
    }

    //wordbyword matching,,time complexity is O(N M)
    static String commonPrefix6(String arr[], int n) {
        String prefix = arr[0];
        for (int i = 1; i <= n - 1; i++) {
            prefix = commonPrefixUtil(prefix, arr[i]);
        }
        return (prefix);
    }

    public static void main(String[] args) {
        String arr[] = {"geeksforgeeks", "geeks",
                "geek", "geezer"};
        int n = arr.length;
        commonPrefix1(arr, n);
        String ans = commonPrefix4(arr, 0, n - 1);

    }
}
