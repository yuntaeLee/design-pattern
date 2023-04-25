package creational_patterns.builder;

public class ComputerBuilderTest {
    
    public static void main(String[] args) {
        Computer comp = new Computer.ComputerBuilder("512 GB", "16 GB")
                            .isGraphicsCardEnabled(true)
                            .isBluetoothEnabled(true)
                            .build();

        System.out.println(comp);
    }
}
