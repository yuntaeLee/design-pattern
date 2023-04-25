package creational_patterns.factory;

import model.Computer;

public class ComputerFactoryTest {
    
    public static void main(String[] args) {
        Computer pc = ComputerFactory.getComputer("pc", "2.4 GHz", "16 GB", "512 GB");
        Computer server = ComputerFactory.getComputer("server", "2.9 GHz", "32 GB", "1 TB");

        System.out.println("Factory PC Config: " + pc);
        System.out.println("Factory Server Config: " + server);
    }
}
