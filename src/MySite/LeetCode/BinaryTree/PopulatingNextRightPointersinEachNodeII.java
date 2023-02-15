package MySite.LeetCode.BinaryTree;
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
public class PopulatingNextRightPointersinEachNodeII {
    public static void main(String[] args) {

    }
    public Node connect(Node root) {
        Node head = root;
        while(head != null){
            Node dummy = new Node();
            Node temp = dummy;
            while(head != null){
                if(head.left != null){
                    temp.next = head.left;
                    temp = temp.next;
                }
                if(head.right != null){
                    temp.next = head.right;
                    temp = temp.next;
                }
                head = head.next;
            }
            head = dummy.next;
        }
        return root;
    }
}
