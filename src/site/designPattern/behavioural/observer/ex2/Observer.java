package site.designPattern.behavioural.observer.ex2;

import MySite.DesignPattern.observer.exp2.Message;

public interface Observer {
    //method to update the observer, used by subject
    public void update(Message m);

    //attach with subject to observe
    public void setSubject(Subject sub);
}
