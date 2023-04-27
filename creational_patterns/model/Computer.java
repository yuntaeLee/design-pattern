package creational_patterns.model;

public abstract class Computer {
    
    public abstract String getCPU();
    public abstract String getRAM();
    public abstract String getHDD();

    @Override
    public String toString() {
        return "CPU = " + this.getCPU() + ", RAM = " + this.getRAM() + ", HDD = " + this.getHDD();
    }
}
