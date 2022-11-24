package site.designPattern.behavioural.pubSub.ex1;

import java.util.Map;

public class ExampleSubscriber implements Subscriber {

    @Override
    public void update(Map map) {
        System.out.println(map.get("oldCachedValue"));
        System.out.println(map.get("newCachedValue"));
    }

}