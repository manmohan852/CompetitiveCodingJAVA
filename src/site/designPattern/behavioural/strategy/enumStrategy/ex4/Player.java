package site.designPattern.behavioural.strategy.enumStrategy.ex4;

public class Player {
    private PlayStrategy battingStrategy;

    public Player(PlayStrategy battingStrategy) {
        this.battingStrategy = battingStrategy;
    }

    public void setStrategy(PlayStrategy newStrategy) {
        this.battingStrategy = newStrategy;
    }

    public void play() {
        battingStrategy.play();
    }

}
