package site.systemDesign.HitCounter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HitCounterMap {

    HashMap<Integer, Integer> hits;
    public HitCounterMap() {
        hits=new HashMap<Integer, Integer>();
    }

    public void hit(int timestamp) {
        hits.put(timestamp, hits.getOrDefault(timestamp,0)+1);
    }

    public int getHits(int timestamp) {
        int res=0;
        Set<Integer> set=new HashSet<>();
        for(Integer i: hits.keySet()){
            if(i>timestamp-300){
                res+=hits.get(i);
            }else set.add(i);
        }
        for(Integer i: set) {
            hits.remove(i);
        }
        return res;
    }
}
