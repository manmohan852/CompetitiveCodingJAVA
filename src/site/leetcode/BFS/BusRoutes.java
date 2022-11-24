package site.leetcode.BFS;

import java.util.*;

//https://leetcode.com/problems/bus-routes/
//815. Bus Routes
public class BusRoutes {

    Set<Integer> vb;
    Set<Integer> vs;
    Map<Integer, List<Integer>> map;
    int m;

    public int numBusesToDestination(int[][] rs, int S, int T) {
        vs = new HashSet<>();
        vb = new HashSet<>();
        map = new HashMap<>();
        m = rs.length;
        for (int i = 0; i < m; i++) {
            for (int stop : rs[i]) {
                map.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int res = 0;
        q.add(S);
        while (!q.isEmpty()) {
            int l = q.size();
            for (int i = 0; i < l; i++) {
                int stop = q.poll();
                if (stop == T) return res;
                if (!map.containsKey(stop)) continue;
                vs.add(stop);
                for (int bus : map.get(stop)) {
                    if (vb.contains(bus)) continue;
                    vb.add(bus);
                    for (int st : rs[bus]) {
                        if (vs.contains(st)) continue;
                        vs.add(st);
                        q.offer(st);
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
