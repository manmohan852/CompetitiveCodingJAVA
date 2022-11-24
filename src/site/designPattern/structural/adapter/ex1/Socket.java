package site.designPattern.structural.adapter.ex1;

public class Socket {

    public Volt getVolt(){
        return new Volt(120);
    }
}
