package creational_patterns.abstract_factory;

import creational_patterns.model.Computer;

public class ComputerFactory {
    
    public static Computer getComputer(ComputerAbstractFactory factory) {
        return factory.createComputer();
    }
}
