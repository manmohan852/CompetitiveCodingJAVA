package site.designPattern.behavioural.pubSub.ex1;

import java.util.Map;

public class ExampleSubscriber2 implements Subscriber {

    @Override
    public void update(Map map) {
        System.out.println(map.get("val1"));
        System.out.println(map.get("val2"));
    }

}