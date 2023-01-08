package MySite.DesignPattern.observer.exp2;

import site.designPattern.behavioural.observer.ex2.Observer;

public interface Subject
{
    public void attach(Observer o);
    public void detach(Observer o);
    public void notifyUpdate(Message m);
}