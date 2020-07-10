package site.designPattern.creational.abstractFactory.ex1;

public class ComputerFactory {

    public static Computer getComputer(ComputerAbstractFactory factory){
        return factory.createComputer();
    }
}
