package site.designPattern.behavioural.state.ex3;
//https://www.baeldung.com/java-state-design-pattern
public class StateTest {

    public static void main(String[] args) {

        Package pkg = new Package();
        pkg.printStatus();

        pkg.nextState();
        pkg.printStatus();

        pkg.nextState();
        pkg.printStatus();

        pkg.nextState();
        pkg.printStatus();
    }
}
