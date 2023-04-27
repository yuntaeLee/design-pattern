package creational_patterns.abstract_factory;

import creational_patterns.model.Computer;
import creational_patterns.model.Server;

public class ServerFactory implements ComputerAbstractFactory {
    
    private String cpu;
    private String ram;
    private String hdd;

    public ServerFactory(String cpu, String ram, String hdd) {
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;   
    }

    @Override
    public Computer createComputer() {
        return new Server(cpu, ram, hdd);
    }
}
