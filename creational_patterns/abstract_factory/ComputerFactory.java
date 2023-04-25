package creational_patterns.abstract_factory;

import model.Computer;

public class ComputerFactory {
    
    public static Computer getComputer(ComputerAbstractFactory factory) {
        return factory.createComputer();
    }
}
