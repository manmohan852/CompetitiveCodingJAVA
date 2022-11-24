package site.javaTest.basics.immutable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class ImmutableStudent {

    private final int id;
    private final String name;
    private final List<String> stuff;
    private final Age age;
    private final HashMap<String, String> properties;


    public ImmutableStudent(int id, String name, Age age, HashMap<String, String> properties, List<String> stuff) {
        this.name = name;
        this.id = id;
        this.stuff = new ArrayList<>(stuff);

        Age cloneAge = new Age();
        cloneAge.setDay(age.getDay());
        cloneAge.setMonth(age.getMonth());
        cloneAge.setYear(age.getYear());
        this.age = cloneAge;

        //Shallow Copy
        //this.properties = properties;

        //DEEP COPY
        HashMap<String,String> tempMap=new HashMap<>();
        String key;
        Iterator<String> it = properties.keySet().iterator();
        while(it.hasNext()){
            key=it.next();
            tempMap.put(key, properties.get(key));
        }
        this.properties=tempMap;

        //DEEP COPY:: another method
        //this.properties = (HashMap<String, String>) properties.clone();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getStuff() {
        return new ArrayList<>(stuff);
    }

    public HashMap<String, String> getProperties() {
        return (HashMap<String, String>) properties.clone();
    }

    public Age getAge() {
        Age cloneAge = new Age();
        cloneAge.setDay(this.age.getDay());
        cloneAge.setMonth(this.age.getMonth());
        cloneAge.setYear(this.age.getYear());
        return cloneAge;
    }
}
