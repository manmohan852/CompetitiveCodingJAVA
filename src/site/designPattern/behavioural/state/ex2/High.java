package site.designPattern.behavioural.state.ex2;

class High implements State {
    public void pull(CeilingFanPullChain wrapper) {
        wrapper.set_state(new Off());
        System.out.println("turning off");
    }
}
