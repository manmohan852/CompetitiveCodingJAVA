package site.interview.designDS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
//https://www.geeksforgeeks.org/design-a-data-structure-that-supports-insert-delete-search-and-getrandom-in-constant-time/
public class DesignDSInsertDeleteGetRandomInO1 {

    //Time complexity O(1). -- Space complexity O(N).
    //Cannot handle Duplicates;
    static class NewDS {
        ArrayList<Integer> al;
        HashMap<Integer, Integer> mp;

        public NewDS(ArrayList<Integer> al, HashMap<Integer, Integer> mp) {
            this.al = al;
            this.mp = mp;
        }

        public void insert(Integer a) {
            if (mp.containsKey(a)) {
                System.out.println("Element is already present ");
            } else {
                al.add(a);
                mp.put(a, al.size() - 1);
            }
        }

        public String remove(Integer a) {
            if (mp.containsKey(a)) {
                int size = al.size();
                int index = mp.get(a);
                int last = al.get(size - 1);
                Collections.swap(al, index, size - 1);
                al.remove(size - 1);
                mp.put(last, index);
                return "Data Deleted";
            } else {
                return "Data Not found";
            }
        }

        public Integer getRandom() {
            Random rm = new Random();
            int index = rm.nextInt(al.size());
            return al.get(index);
        }

        //return index at which element is present
        public Integer contains(Integer a) {
            if(mp.containsKey(a)){
                return mp.get(a);
            }
            else{
                return null;
            }
        }
    }

    public static void main(String[] args) {
        NewDS newDS = new NewDS(new ArrayList<>(),new HashMap<>());
        newDS.insert(5);
        newDS.insert(6);
        newDS.insert(8);
        newDS.insert(7);
        newDS.insert(6);

        System.out.println();

    }

}
