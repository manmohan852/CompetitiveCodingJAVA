package site.gfg.trie;

public class TrieStringFreq {
    static TrieNode root;
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
    }

    public static  int searchStringFrequency(String str){
        TrieNode pCrawl = root;
        int len = str.length();
        for (int i =0;i<len;i++){
            int index = str.charAt(i) - 'a';
            if(pCrawl.children[index] == null)
                return 0;
            pCrawl = pCrawl.children[index];
        }
        return pCrawl.count;
    }

    public static void main(String[] args) {
        String arr[] = {"aba","baba","aba","xzxb","ab","ab","aba"};
        int n = arr.length;
        String query[] = {"aba","xzxb","ab"};
        int q = query.length;

        answerQueries(arr,n,query,q);
    }

    private static void answerQueries(String[] arr, int n, String[] query, int q) {
        root = new TrieNode();
        for (int i=0;i<n;i++){
            insert(arr[i]);
        }

        for (int i=0;i<q;i++){
            int count = searchStringFrequency(query[i]);
            System.out.println(count);
        }
    }
}
