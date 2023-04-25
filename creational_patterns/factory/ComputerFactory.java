package creational_patterns.factory;

import creational_patterns.model.Computer;
import creational_patterns.model.PC;
import creational_patterns.model.Server;

public class ComputerFactory {
    
    public static Computer getComputer(String type, String cpu, String ram, String hdd) {
        if ("PC".equalsIgnoreCase(type)) return new PC(cpu, ram, hdd);
        else if ("Server".equalsIgnoreCase(type)) return new Server(cpu, ram, hdd);

        return null;
    }
}
