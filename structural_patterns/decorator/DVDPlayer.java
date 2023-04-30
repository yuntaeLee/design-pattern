package structural_patterns.decorator;

public class DVDPlayer {
    
    private State state;

    private DVDPlayer() {}

    private static class SingletonHelper {
        private static final DVDPlayer INSTANCE = new DVDPlayer();
    }

    public static DVDPlayer getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void changeState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void openCloseButtonPushed() {
        state.openCloseButtonPushed();
    }

    public void playButtonPushed() {
        state.playButtonPushed();
    }

    public void stopButtonPushed() {
        state.stopButtonPushed();
    }

    public void open() {
        System.out.println("Open DVDPlayer's Drawer.");
    }

    public void close() {
        System.out.println("Close DVDPlayer's Drawer.");
    }

    public void play() {
        System.out.println("Play DVD.");
    }

    public void stop() {
        System.out.println("Stop playing DVD.");
    }
}
