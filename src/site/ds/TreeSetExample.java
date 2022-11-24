package site.ds;

import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        try {
            TreeSet<Integer> treeadd = new TreeSet<Integer>();
            treeadd.add(10);
            treeadd.add(20);
            treeadd.add(30);
            treeadd.add(40);
            System.out.println("TreeSet: " + treeadd);

            int value = treeadd.floor(25);
            System.out.println("Floor value for 25: " + value);
            int value2 = treeadd.floor(null); // throws nullPointerException

            int value3 = treeadd.ceiling(25);
            System.out.println("Ceiling value for 25: " + value);

            System.out.println(treeadd.lower(15));

            System.out.println(treeadd.higher(15));

            System.out.println("Does the Set contains 'TreeSet'? " + treeadd.contains("TreeSet"));

            System.out.println("The first element is: " + treeadd.first());

            System.out.println("The last element is: " + treeadd.last());

            System.out.println("Is the set empty? " + treeadd.isEmpty());

            treeadd.clear();

            System.out.println("The size of the set is: " + treeadd.size());

        }catch (Exception e){

        }
    }
}
