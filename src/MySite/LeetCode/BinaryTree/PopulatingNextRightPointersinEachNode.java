package MySite.LeetCode.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
public class PopulatingNextRightPointersinEachNode {
    public static void main(String[] args) {

    }
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            Node pre = null;
            for(int i = 0; i < size; i++){
                Node first = q.poll();
                if(pre != null){
                    pre.next = first;
                }
                pre = first;
                if(first.left != null){
                    q.add(first.left);
                    q.add(first.right);
                }
            }
        }
        return root;
    }
}
