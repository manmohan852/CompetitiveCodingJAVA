package site.designPattern.behavioural.pubSub.ex1;

public enum Topic {
    ON_CACHE_RESET("onCacheReset"), ON_CACHE_SET("onCacheSet");

    String topicName;

    Topic(String topicName){
        this.topicName = topicName;
    }
}
