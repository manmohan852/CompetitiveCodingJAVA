package site.interview.rupeek;

import java.util.HashMap;
import java.util.Map;
//TODO
//rupeek
public class APairWithLeastEnergy {


    public static long calculateEnergy(long n, Map<Long, Long> longMap) {
        if(longMap.containsKey(n)) return longMap.get(n);
        long e = 0;
        while(n > 0) {
            e += n % 10;
            n = n / 10;
        }
        longMap.put(n,e);
        return e;
    }


    public static long countMinEnergy(long n) {
        Map<Long,Long>  longMap = new HashMap<>();
        long minE = n;
        long i = 1;
        while(i <= n/2) {
            long e = calculateEnergy(i,longMap) + calculateEnergy(n - i,longMap);
            minE = e < minE ? e : minE;
            i++;
        }
        return minE;
    }

    public static void main(String[] args) {
        String s = "804589571040855338";
        long n = Long.parseLong(s);
        long ans = countMinEnergy(n);
        System.out.println();
    }
}
