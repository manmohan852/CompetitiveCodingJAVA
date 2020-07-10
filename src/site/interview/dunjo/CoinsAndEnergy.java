package site.interview.dunjo;

import java.util.*;

public class CoinsAndEnergy {
    static List<Integer> energy;
    static List<Integer> coins;
    static int n;

    public static int getRich(Long initialEnergy, List<Integer> energy, List<Integer> coins) {
        int ans1 = 0;
        Map<Long, Map<Long, Integer>> energyMap = new HashMap<>();
        if (initialEnergy == 0) {
            ans1 = getMaxCoin(1l, 0, Long.valueOf(energy.get(0)), energyMap);
            return ans1;
        }
        ans1 = Math.max(ans1,getMaxCoin(0l, 0, initialEnergy, energyMap));
        return ans1;
    }

    public static int getMaxCoin(Long index, int currentCoin, Long currEnergy, Map<Long, Map<Long, Integer>> energyMap) {
        if (energyMap.containsKey(index)) {
            Map<Long, Integer> map = energyMap.get(index);
            if (map != null && map.containsKey(currEnergy)) {
                return map.get(currEnergy);
            }
        }
        if (index == n) {
            updateEnergyMap(index, currentCoin, currEnergy, energyMap);
            return currentCoin;
        }
        if (currEnergy > 0) {
            int ans1 = getMaxCoin(index + 1, currentCoin + coins.get(index.intValue()), currEnergy - 1, energyMap);
            if (index == 0) {
                ans1 = Math.max(ans1,getMaxCoin(index + 1, currentCoin, currEnergy + energy.get(Math.toIntExact(index)), energyMap));
            } else {
                ans1 = Math.max(ans1,getMaxCoin(index + 1, currentCoin, currEnergy - 1 + energy.get(Math.toIntExact(index)), energyMap));
            }
            updateEnergyMap(index, ans1, currEnergy, energyMap);
            return ans1;
        }
        updateEnergyMap(index, currentCoin, currEnergy, energyMap);
        return currentCoin;//stop at that position, no need to further
    }

    private static void updateEnergyMap(Long index, int currentCoin, Long currEnergy, Map<Long, Map<Long, Integer>> energyMap) {
        if (energyMap.containsKey(index)) {
            Map<Long, Integer> map = energyMap.get(index);
            if (map != null) {
                if(map.containsKey(currEnergy)){
                    map.put(currEnergy,Math.max(map.get(currEnergy),currentCoin));
                }else {
                    map.put(currEnergy, currentCoin);
                }
            }else{
                map  = new HashMap<>();
                map.put(currEnergy,currentCoin);
            }
            energyMap.put(index,map);
        }else{
            Map<Long, Integer> map  = new HashMap<>();
            map.put(currEnergy,currentCoin);
            energyMap.put(index,map);
        }
    }

    public static void main(String[] args) {
        //input1
//        n = 3;
//        energy = new ArrayList<>(Arrays.asList(2,1,1));
//        coins = new ArrayList<>(Arrays.asList(11,5,7));
//        int initialEnergy = 0;

        //input2
        n = 3;
        energy = new ArrayList<>(Arrays.asList(12,2,2));
        coins = new ArrayList<>(Arrays.asList(5,5,5));
        Long initialEnergy = 1999l;

        //input3
//        n = 5;
//        energy = new ArrayList<>(Arrays.asList(1, 5, 3, 3, 1));
//        coins = new ArrayList<>(Arrays.asList(3, 23, 9, 2, 2));
//        Long initialEnergy = 1l;

        getRich(initialEnergy, energy, coins);
    }
}
