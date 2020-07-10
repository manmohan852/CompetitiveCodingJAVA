package site.interview.designDS;

import java.util.*;
///https://www.geeksforgeeks.org/design-a-data-structure-that-supports-insert-delete-getrandom-in-o1-with-duplicates/
public class DesignDSInsertDeleteGetRandomInO1WithDuplicates {

    //Time complexity O(1). -- Space complexity O(N).
    //Can handle Duplicates;
    static class NewDS {
        ArrayList<Integer> al;
        HashMap<Integer, List<Integer>> mp;

        public NewDS(ArrayList<Integer> al, HashMap<Integer, List<Integer>> mp) {
            this.al = al;
            this.mp = mp;
        }

        public void insert(Integer a) {
            al.add(a);
            int index = al.size() - 1;
            List<Integer> indexes;
            if (mp.containsKey(a)) {
                indexes = mp.get(a);
            } else {
                indexes = new ArrayList<>();
            }
            indexes.add(index);
            mp.put(a, indexes);
        }

        public String remove(Integer a) {
            if (mp.containsKey(a)) {
                int size = al.size();
                int last = al.get(size - 1);

                List<Integer> indexes = mp.get(a);
                int indexesSize = indexes.size();
                int arrIndex = indexes.get(indexesSize - 1);
                indexes.remove(indexes.size() - 1);
                if (indexes.isEmpty()) {
                    mp.remove(a);
                } else {
                    mp.put(a, indexes);
                }


                if (last != a) {
                    Collections.swap(al, arrIndex, size - 1);

                    List<Integer> lastElementindexes = mp.get(last);
                    int lastElementindexesSize = lastElementindexes.size();
                    lastElementindexes.set(lastElementindexesSize - 1, arrIndex);
                    mp.put(last, lastElementindexes);
                }
                al.remove(size - 1);
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
        public List<Integer> contains(Integer a) {
            if (mp.containsKey(a)) {
                return mp.get(a);
            } else {
                return null;
            }
        }
    }

    public static void main(String[] args) {
        NewDS newDS = new NewDS(new ArrayList<>(), new HashMap<>());
        newDS.insert(5);
        newDS.insert(10);
        newDS.insert(8);
        newDS.insert(10);
        newDS.insert(6);
        newDS.insert(10);
        newDS.insert(10);
        newDS.remove(8);
        newDS.remove(5);

        System.out.println();

    }
}
