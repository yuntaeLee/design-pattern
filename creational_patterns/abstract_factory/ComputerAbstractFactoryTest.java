package creational_patterns.abstract_factory;

import creational_patterns.model.Computer;

public class ComputerAbstractFactoryTest {
    
    public static void main(String[] args) {
        testAbstractFactory();
    }

    private static void testAbstractFactory() {
        Computer pc = ComputerFactory.getComputer(new PCFactory("2.4 GHz", "16 GB", "512 GB"));
        Computer server = ComputerFactory.getComputer(new ServerFactory("2.9 GHz", "32 GB", "1 TB"));
        
        System.out.println("AbstractFactory PC Config: " + pc);
		System.out.println("AbstractFactory Server Config: " + server);
    }
}
