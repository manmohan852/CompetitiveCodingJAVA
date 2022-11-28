package site.interview.repro;

import java.util.Iterator;
import java.util.LinkedList;

public class MCQProblems {


    public static void main(String[] args) {
        LinkedList<String> list_1=new LinkedList<String>();
        list_1.add("Alice");
        list_1.add("Mike");
        LinkedList<String> list_2=new LinkedList<String>();
        list_2.add("Bob");
        list_2.add("Lisa");
        list_2.addAll(0,list_1);
        list_2.addLast("Bob");
        list_2.remove("Bob");
        Iterator itr=list_2.descendingIterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }
    }
}
