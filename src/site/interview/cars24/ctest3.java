package site.interview.cars24;

import java.util.ArrayList;
import java.util.Spliterator;

public class ctest3 {
    public static void main(String[] args) {
        ArrayList<Double> vals = new ArrayList<>();
        vals.add(1.0);
        vals.add(4.0);
        vals.add(16.0);
        Spliterator<Double> spltitr = vals.spliterator();
        while(spltitr.tryAdvance((n) -> System.out.println(" " + n)));
        System.out.println();
        spltitr = vals.spliterator();
        ArrayList<Double> sqrs = new ArrayList<>();
        while(spltitr.tryAdvance((n) -> sqrs.add(Math.sqrt(n))));
        spltitr = sqrs.spliterator();
        spltitr.forEachRemaining((n) -> System.out.println(" " + n));
    }
}
