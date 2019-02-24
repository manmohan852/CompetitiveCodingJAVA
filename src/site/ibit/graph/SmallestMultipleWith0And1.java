package site.ibit.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class SmallestMultipleWith0And1 {
    private static class Node{
        public final boolean isDigitOne;
        public final int val;
        public final Node prev;

        public Node(boolean isDigitOne,int val,Node prev){
            this.isDigitOne = isDigitOne;
            this.val = val;
            this.prev = prev;
        }


    }

    public static String multiple(int num){
        if(num < 0) throw new IllegalArgumentException("invalid number");

        String result = "0";
        if(num > 0){
            boolean[] isVisited = new boolean[num];
            Arrays.fill(isVisited,false);

            Queue<Node> q = new ArrayDeque<>();

            q.add(new Node(true,1 % num,null));
            isVisited[1 % num] = true;

            Node destNode  = null;

            while (!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode.val == 0){
                    destNode = currNode;
                    break;
                }else{
                    int val1 = (currNode.val * 10 ) % num;
                    if(!isVisited[val1]){
                        q.add(new Node(false,val1,currNode));
                        isVisited[val1] = true;
                    }


                    int val2 = val1 + 1;
                    if(val2 == num){
                       val2 = 0;
                    }
                    if(!isVisited[val2]){
                        q.add(new Node(true,val2,currNode));
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            if(destNode == null){
                    throw new IllegalArgumentException("invalid output");
            }else {
                Node currNode = destNode;
                while (currNode != null){
                    sb.append(currNode.isDigitOne ? 1 : 0);
                    currNode = currNode.prev;
                }
                result =  sb.reverse().toString();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(multiple(9));
    }
}
