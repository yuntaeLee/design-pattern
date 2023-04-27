package structural_patterns.adapter;

public class SocketClassAdapterImpl extends Socket implements SocketAdapter {

    @Override
    public Volt get120Volt() {
        return getVolt();
    }

    @Override
    public Volt get12Volt() {
        Volt v = getVolt();
        return converVolt(v, 10);
    }

    @Override
    public Volt get3Volt() {
        Volt v = getVolt();
        return converVolt(v, 40);
    }

    private Volt converVolt(Volt v, int i) {
        return new Volt(v.getVolts() / i);
    }
}
