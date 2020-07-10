package site.designPattern.behavioural.state.ex1;

public class TVStopState implements State {

    @Override
    public void doAction() {
        System.out.println("TV is turned OFF");
    }

}