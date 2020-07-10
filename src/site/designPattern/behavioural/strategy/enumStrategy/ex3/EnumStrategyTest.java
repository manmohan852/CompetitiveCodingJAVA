package site.designPattern.behavioural.strategy.enumStrategy.ex3;
//https://readlearncode.com/design-patterns/an-enum-implementation-of-the-strategy-pattern/#:~:text=Enum%20implementation%20of%20the%20Strategy%20Design%20Pattern&text=This%20implementation%20only%20requires%20two,definition%20of%20each%20enum%20constant.
public class EnumStrategyTest {

    public static void main(String[] args) {
        EnumStrategyTest enumStrategyTest = new EnumStrategyTest();
        enumStrategyTest.perform(Strategy.STRATEGY_A);
        enumStrategyTest.perform(Strategy.STRATEGY_B);
    }

    private void perform(Strategy strategy) {
        strategy.execute();
    }

}