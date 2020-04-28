package site.gfg.trie;

public class TrieWordCount {
    static final int ALPHABET_SIZE = 26;

    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isLeaf;
        TrieNode() {
            isLeaf = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }
    static TrieNode root;
    static void insert(String key) {
        int length = key.length();
        TrieNode pCrawl = root;
        for (int level = 0; level < length; level++) {
            int index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();
            pCrawl = pCrawl.children[index];
        }
        pCrawl.isLeaf = true;
    }

    static int wordCount(TrieNode root) {
        int result = 0;
        if (root.isLeaf)
            result++;
        for (int i = 0; i < ALPHABET_SIZE; i++)
            if (root.children[i] != null)
                result += wordCount(root.children[i]);
        return result;
    }

    public static void main(String args[]) {
        // Input keys (use only 'a' through 'z'
        // and lower case)
        String keys[] = {"the", "a", "there", "answer",
                "any", "by", "bye", "their"};

        root = new TrieNode();
        for (int i = 0; i < keys.length; i++)
            insert(keys[i]);

        System.out.println(wordCount(root));
    }
}
