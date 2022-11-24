package site.designPattern.behavioural.strategy.enumStrategy.ex4;

public class Match {

    public static void main(String args[]) {
        Player ctx = new Player(PlayStrategy.T20);
        ctx.play();
        ctx.setStrategy(PlayStrategy.ONE_DAY);
        ctx.play();
        ctx.setStrategy(PlayStrategy.TEST);
        ctx.play();
    }

}
