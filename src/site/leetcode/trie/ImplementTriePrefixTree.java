package site.leetcode.trie;
//208. Implement Trie (Prefix Tree)
//https://leetcode.com/problems/implement-trie-prefix-tree/
public class ImplementTriePrefixTree {
    class Node {
        char c;
        Node[] arr;
        boolean b;

        Node(char c) {
            this.c = c;
            this.arr = new Node[26];
        }
    }

    Node root;

    public ImplementTriePrefixTree() {
        this.root = new Node('\0');
    }

    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            Node temp = node.arr[c - 'a'];
            if (temp == null) {
                temp = new Node(c);
                node.arr[c - 'a'] = temp;
            }
            node = temp;
        }
        node.b = true;
    }

    public boolean search(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            Node temp = node.arr[c - 'a'];
            if (temp == null) {
                return false;
            }
            node = temp;
        }
        return node.b;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (char c : prefix.toCharArray()) {
            Node temp = node.arr[c - 'a'];
            if (temp == null) {
                return false;
            }
            node = temp;
        }
        return true;
    }

    public static void main(String[] args) {
        ImplementTriePrefixTree obj = new ImplementTriePrefixTree();
        obj.insert("the");
        obj.insert("there");
        obj.insert("their");
        obj.insert("any");
        obj.insert("by");
        obj.insert("bye");
        boolean param_2 = obj.search("any");
        System.out.println(param_2);
        boolean param_3 = obj.startsWith("th");
        System.out.println(param_3);
    }


}
