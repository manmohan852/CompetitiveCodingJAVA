package site.designPattern.behavioural.strategy.enumStrategy.ex3;

public enum Strategy {

    STRATEGY_A {
        @Override
        void execute() {
            System.out.print("Executing strategy A");
        }
    },

    STRATEGY_B {
        @Override
        void execute() {
            System.out.print("Executing strategy B");
        }
    };

    abstract void execute();
}