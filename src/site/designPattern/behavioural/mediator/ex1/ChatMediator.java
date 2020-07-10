package site.designPattern.behavioural.mediator.ex1;

public interface ChatMediator {

    public void sendMessage(String msg, User user);

    void addUser(User user);
}
