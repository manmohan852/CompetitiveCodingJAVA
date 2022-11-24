package site.designPattern.creational.abstractFactory.ex1;

import site.designPattern.creational.abstractFactory.ex1.Computer;
import site.designPattern.creational.abstractFactory.ex1.ComputerAbstractFactory;
import site.designPattern.creational.abstractFactory.ex1.Server;

public class ServerFactory implements ComputerAbstractFactory {

    private String ram;
    private String hdd;
    private String cpu;

    public ServerFactory(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }

    @Override
    public Computer createComputer() {
        return new Server(ram,hdd,cpu);
    }

}
