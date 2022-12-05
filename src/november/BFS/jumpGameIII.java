package november.BFS;

public class jumpGameIII {

}
class Solution {
    class Pair{
        public int index;
        public int val;
        public Pair(int index, int val){
            this.index = index;
            this.val = val;
        }
    }
    Set<Integer> set = new HashSet();
    public boolean canReach(int[] arr, int start) {
        Queue<Pair> q = new LinkedList();
        q.add(new Pair(start,arr[start]));
        while(!q.isEmpty()){
            Pair p = q.poll();
            set.add(p.index);
            if(p.val==0) return true;
            if(!set.contains(p.index-p.val) && p.index-p.val>=0){
                q.add(new Pair(p.index-p.val,arr[p.index-p.val]));
            }
            if(!set.contains(p.index+p.val) && p.index+p.val<arr.length){
                q.add(new Pair(p.index+p.val,arr[p.index+p.val]));
            }
        }

        return false;
    }

}