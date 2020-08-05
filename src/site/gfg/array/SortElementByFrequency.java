package site.gfg.array;

import java.util.*;

//https://www.faceprep.in/c-plus-plus/sort-elements-by-frequency-in-an-array/
public class SortElementByFrequency {

    static class Elem {
        int count, index, value;

        public Elem(int count, int index, int value) {
            this.count = count;
            this.index = index;
            this.value = value;
        }
    }

    //Time Complexity : O(n^2)
    private static void sortByFreq(int[] arr) {
        Map<Integer, Elem> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                Elem elem = map.get(arr[i]);
                elem.count += 1;
                map.put(arr[i], elem);
            } else {
                Elem elem = new Elem(1, i, arr[i]);
                map.put(arr[i], elem);
            }
        }
        List<Elem> elems = new ArrayList<>(map.values());
        Collections.sort(elems, new Comparator<Elem>() {
            @Override
            public int compare(Elem elem, Elem t1) {
                if (elem.count != t1.count) {
                    if (elem.count < t1.count) {
                        return 1;
                    } else if (elem.count > t1.count) {
                        return -1;
                    } else {
                        return 0;
                    }
                } else {
                    if (elem.index > t1.index) {
                        return 1;
                    } else if (elem.index < t1.index) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });
        int index = 0;
        for (int i = 0; i < elems.size(); i++) {
            Elem elem = elems.get(i);
            for (int j = 0; j < elem.count; j++) {
                arr[index++] = elems.get(i).value;
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12};
        sortByFreq(arr);
    }

}
