package site.interview.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class closestLocations {

    static class PairInt{
        int first;
        int second;

        public PairInt(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static List<PairInt> closestLocations(int totalcrates,List<PairInt> allLocations,int truckCapacity){
        if(truckCapacity >= totalcrates) return allLocations;
        double[] dists = new  double[totalcrates];
        for (int i = 0;i<totalcrates;i++){
            PairInt pairInt = allLocations.get(i);
            double dis = distance(pairInt);
            dists[i] = dis;
        }
        Arrays.sort(dists);

        double distK = dists[truckCapacity - 1];
        List<PairInt> ans = new ArrayList<>();
        PairInt last = null;
        int t =0;
        for (int i =0;i<totalcrates;i++){
            if(distance(allLocations.get(i)) < distK){
                ans.add(allLocations.get(i));
            }
            if(distance(allLocations.get(i)) == distK && t == 0){
                last = allLocations.get(i);
                ans.add(last);
                t++;
            }
        }
        ans.sort(new Comparator<PairInt>() {
            @Override
            public int compare(PairInt p1, PairInt p2) {
                if(distance(p1) < distance(p2)){
                    return 1;
                }else if(distance(p1) > distance(p2)){
                    return -1;
                }else return 0;
            }
        });
        return ans;
    }

    public static double distance(PairInt pairInt){
       return Math.sqrt(pairInt.first * pairInt.first + pairInt.second * pairInt.second);
    }

    public static void main(String[] args) {
        int totalcrates = 3;
        List<PairInt> allLocations = new ArrayList<>();
        PairInt pairInt1 = new PairInt(1,2);
        PairInt pairInt2 = new PairInt(3,4);
        PairInt pairInt3 = new PairInt(1,-1);
        allLocations.add(pairInt1);
        allLocations.add(pairInt2);
        allLocations.add(pairInt3);
        int truckCapacity  = 2;
        closestLocations(totalcrates,allLocations,truckCapacity);

    }

}
