package site.designPattern.behavioural.observer.ex1;

import site.designPattern.behavioural.observer.ex1.Channel;

public class NewsChannel implements Channel {

    private String news;

    @Override
    public void update(Object news) {
        this.setNews((String) news);
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

}