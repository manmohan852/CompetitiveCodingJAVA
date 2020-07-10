package site.designPattern.behavioural.state.ex2;

class Off implements State {
    public void pull(CeilingFanPullChain wrapper) {
        wrapper.set_state(new Low());
        System.out.println("low speed");
    }
}
