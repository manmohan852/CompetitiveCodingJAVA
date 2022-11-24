package site.designPattern.behavioural.pubSub.ex1;

import java.util.concurrent.ConcurrentHashMap;

public class Publisher {

    Topic topic;

    public Publisher(Topic topic) {
        this.topic = topic;
    }

    public void publish(ConcurrentHashMap map) {
        Broker.getInstance().sendMessage(topic, map);
    }
}
