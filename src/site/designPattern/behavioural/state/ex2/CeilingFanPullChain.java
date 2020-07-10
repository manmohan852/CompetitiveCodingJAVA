package site.designPattern.behavioural.state.ex2;

public class CeilingFanPullChain {
    private State currentState;

    public CeilingFanPullChain() {
        currentState = new Off();
    }

    public void set_state(State s) {
        currentState = s;
    }

    public void pull() {
        currentState.pull(this);
    }
}
