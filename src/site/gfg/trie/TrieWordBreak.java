package site.gfg.trie;

public class TrieWordBreak {
    static final int ALPHABET_SIZE = 26;
    static TrieNode root;

    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }

    public static void insert(String str){
        int len = str.length();
        TrieNode pCrawl = root;
        for (int i=0;i<len;i++){
            int index = str.charAt(i) - 'a';
            if(pCrawl.children[index] == null){
                pCrawl.children[index] = new TrieNode();
            }
            pCrawl = pCrawl.children[index];
        }
        pCrawl.isEndOfWord = true;
    }

    public static boolean search(String str){
        int len = str.length();
        TrieNode pCrawl = root;
        for (int i=0;i<len;i++){
            int index = str.charAt(i) - 'a';
            if(pCrawl.children[index] == null){
                return false;
            }
            pCrawl = pCrawl.children[index];
        }
        return pCrawl != null && pCrawl.isEndOfWord;
    }

    public static boolean wordbreak(String word){
        int len = word.length();
        if(len ==0 ) return true;
        for (int i =1;i<=len;i++){
            if(search(word.substring(0,i)) && wordbreak(word.substring(i,len)))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String dictionary[] =  {"mobile","samsung","sam",
                "sung","ma","mango",
                "icecream","and","go","i",
                "like","ice","cream"};
        int n = dictionary.length;
        root= new TrieNode();
        for (int i=0;i<n;i++){
            insert(dictionary[i]);
        }

        System.out.println( wordbreak("ilikesamsung"));
        System.out.println(wordbreak("samsungandmango"));
    }
}
