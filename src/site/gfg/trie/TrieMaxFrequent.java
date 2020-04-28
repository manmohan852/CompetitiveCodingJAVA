package site.gfg.trie;

public class TrieMaxFrequent {
    static TrieNode root;
    static int maxCount=0;
    static String maxString;
    static final int ALPHABET_SIZE = 26;
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        int count;

        TrieNode() {
            count=0;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }

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
        pCrawl.count++;
        if(pCrawl.count > maxCount){
            maxCount = pCrawl.count;
            maxString = key;
        }
    }

    public static void main(String[] args) {
        String  arr[] = { "geeks", "for", "geeks", "a",
                "portal", "to", "learn", "can", "be","for","for",
                "computer", "science", "zoom", "yup",
                "fire", "in", "be", "data", "geeks","geeks" };
        int n = arr.length;
        root = new TrieNode();

        for (int i=0;i<n;i++){
            insert(arr[i]);
            System.out.println(maxCount + "string is :  "+ maxString);
        }

        System.out.println("final max count");
        System.out.println(maxCount + "  :   " + maxString);
    }
}
