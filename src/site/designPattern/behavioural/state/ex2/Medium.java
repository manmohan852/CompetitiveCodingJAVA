package site.designPattern.behavioural.state.ex2;

class Medium implements State {
    public void pull(CeilingFanPullChain wrapper) {
        wrapper.set_state(new High());
        System.out.println("high speed");
    }
}
