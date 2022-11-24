package site.designPattern.behavioural.state.ex3;

public interface PackageState {
    void next(Package pkg);

    void prev(Package pkg);

    void printStatus();
}
