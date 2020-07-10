package site.designPattern.behavioural.pubSub.ex1;

import java.util.concurrent.ConcurrentHashMap;
//https://medium.com/@sapanparikh18/implementation-of-simple-pub-sub-in-java-27a8d31bac31#:~:text=While%20there%20are%20many%20code,for%20PubSub%20pattern%20in%20Java.&text=Summarizing%20the%20article%20written%20by,if%20there%20are%20two%20classes.
public class PubSubTest {

    public static void main(String[] args) {
        ExampleSubscriber subscriber = new ExampleSubscriber();
        Broker.getInstance().register(Topic.ON_CACHE_RESET,subscriber);

        ExampleSubscriber2 subscribe2r = new ExampleSubscriber2();
        Broker.getInstance().register(Topic.ON_CACHE_SET,subscribe2r);

        Publisher pub1 = new Publisher(Topic.ON_CACHE_RESET);
        ConcurrentHashMap<String,Integer>  map = new ConcurrentHashMap<>();
        map.put("newCachedValue",1234);
        map.put("oldCachedValue",123456);
        pub1.publish(map);



        Publisher pub2 = new Publisher(Topic.ON_CACHE_SET);
        ConcurrentHashMap<String,Integer>  map2 = new ConcurrentHashMap<>();
        map2.put("val1",15);
        map2.put("val2",3456);
        pub2.publish(map2);


    }
}
