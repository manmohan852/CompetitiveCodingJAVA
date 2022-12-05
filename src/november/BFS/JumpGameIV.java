package november.BFS;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class JumpGameIV {
    public void main(String[] args) {
        int[] arr = {100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        int ans = minJumps(arr);
        System.out.println(ans);
    }
    public int minJumps(int[] arr) {
        int n = arr.length;
        HashMap<Integer, List<Integer>> map = new HashMap();
        for(int i=0; i<n; i++){
            map.putIfAbsent(arr[i], new ArrayList());
            map.get(arr[i]).add(i);
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        Queue<Integer> q = new LinkedList();
        q.offer(0);
        while(!q.isEmpty()){
            int pos = q.poll();
            int curDist = dist[pos];
            if(pos==n-1){
                break;
            }
            if(pos-1>0 && dist[pos-1]>curDist+1){
                dist[pos-1] = curDist+1;
                q.offer(pos-1);
            }

            if(pos+1<n && dist[pos+1]>curDist+1){
                dist[pos+1] = curDist+1;
                q.offer(pos+1);
            }
            List<Integer> nextList = map.get(arr[pos]);
            if(nextList!=null){
                for(int i=0; i<nextList.size(); i++){
                    int next = nextList.get(i);
                    if(next!=pos && dist[next]>curDist+1){
                        dist[next] = curDist+1;
                        q.offer(next);
                    }
                }
            }
            map.remove(arr[pos]);
        }
        return dist[n-1];
    }
}
