package site.javaTest.basics.unmodifiable;

import java.util.*;

public class UnModifiableTest {

    //if you modify the original list & map, then the unmodfiable list/map gets changed,
    // however you cannot directly change the entries.

    public static void test1(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        System.out.println("Initial Unmodifiable Map: "+map);
        Map<Integer, String> map2 = Collections.unmodifiableMap(map);
        map2.put(3, "three");//UnsupportedOperationException is thrown here
    }

    public static void test2(){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1001);
        map.put(2, 1002);
        map.put(3, 1003);
        map.put(4, 1004);
        map.put(5, 1005);
        System.out.println("modifiable map: " + map);
        Map<Integer, Integer> map2 = Collections.unmodifiableMap(map);
        System.out.println("Unmodifiable map: " + map2);
        map.remove(4, 1004);
        System.out.print("Unmodifiable map after remove(4, 1004): "+map2);
    }

    public static void test3(){
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("key1", "Java");
        map.put("key2", "Android");
        map.put("key3", "JavaScript");
        System.out.println("Initial collection: "+map);
        //Create unmodifiable map
        Map<String,String> map2 = Collections.unmodifiableMap(map);
        System.out.println("Unmodifiable Map: " + map2);
        map.put("key4", "JavaTpoint");
        System.out.println("Unmodifiable Map after adding: " + map2);
    }

    public static void test4(){
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Google", "Mozila FireFox", "Yahoo");
        List<String> list2 = Collections.unmodifiableList(list);
        System.out.println("Unmodifiable List: " + list2);
        list.add("Safari");
        System.out.print("Unmodifiable List after adding element to the list:");
        System.out.println(list2);
    }

    public static void test5(){
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Google", "Mozila FireFox", "Yahoo");
        List<String> list2 = Collections.unmodifiableList(list);
        System.out.println("Unmodifiable List: " + list2);
        list2.add("Safari");
    }

    public static void test6(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        List<Integer> list2 = Collections.unmodifiableList(list);
        System.out.println("Unmodifiable list: " + list2);
        list.add(50);
        System.out.println("Unmodifiable list after adding (50): "+list);
    }

    public static void main(String[] args) {
        //test1();
//        test2();
        test3();
    }
}
