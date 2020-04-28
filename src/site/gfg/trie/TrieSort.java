package site.gfg.trie;

public class TrieSort {
    static final int ALPHABET_SIZE = 26;
    static TrieNode root;

    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        int  arrIndex;

        TrieNode() {
            arrIndex = -1;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }

    static void insert(String key,int arrIndex) {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;
        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }
        pCrawl.arrIndex = arrIndex;
    }


    public static void main(String[] args) {
        String  arr[] = { "abc", "xy", "bcd" };
        int n= arr.length;
        root = new TrieNode();
        printSorted(arr,n);
    }

    public static void preOrder(String arr[],int n,TrieNode pCrawl){
        if(pCrawl == null) return;
        for (int i=0;i < ALPHABET_SIZE;i++){
            if(pCrawl.children[i] != null){
                if(pCrawl.children[i].arrIndex != -1){
                    System.out.println(arr[pCrawl.children[i].arrIndex]);
                }
                preOrder(arr,n,pCrawl.children[i]);
            }
        }
    }

    public static void printSorted(String arr[],int n){
        for (int i=0;i<n;i++){
            insert(arr[i],i);
        }
        preOrder(arr,n,root);
    }
}
