package site.designPattern.behavioural.pubSub.ex1;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class Broker {
    private  final Object mutex = new Object();

    private static Broker brokerInstance;

    private Broker() {
    }

    public static Broker getInstance() {
        if (null == brokerInstance) {
            brokerInstance = new Broker();
        }
        return brokerInstance;
    }

    private ConcurrentHashMap<Topic,Set<Subscriber>> subscribers = new ConcurrentHashMap<>();

    public boolean deregister(Topic topic, Subscriber subscriber) {
        synchronized (mutex) {
            final Set<Subscriber> subs = this.subscribers.get(topic);
            return subs.remove(subscriber);
        }
    }

    public boolean register(Topic topic, Subscriber subscriber) {
        boolean returnVal;
        synchronized (mutex) {
            if (subscribers.containsKey(topic)) {
                returnVal = subscribers.get(topic).add(subscriber);
            } else {
                Set<Subscriber> sub = new HashSet<>();
                returnVal = sub.add(subscriber);
                subscribers.put(topic, sub);
            }
        }
        return returnVal;
    }

    public void sendMessage(Topic topic, ConcurrentHashMap map) {
        synchronized (mutex) {
            final Set<Subscriber> sub = this.subscribers.get(topic);
            sub.parallelStream().forEach(subscriber -> subscriber.update(map));
        }
    }

}