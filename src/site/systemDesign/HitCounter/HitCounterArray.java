package site.systemDesign.HitCounter;

import java.util.ArrayList;

public class HitCounterArray {
    ArrayList<Integer> hits;
    public HitCounterArray() {
        hits = new ArrayList<>();
    }

    public void hit(int timestamp) {
        hits.add(timestamp);
    }

    public int getHits(int timestamp) {
        int startRange = timestamp - 300 < 0 ? 0 : timestamp - 300;
        int count = 0;
        for (int hit : hits) {
            if (hit > startRange) {
                count++;
            }
        }
        return count;
    }
}
