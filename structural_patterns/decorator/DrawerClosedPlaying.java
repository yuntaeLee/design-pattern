package structural_patterns.decorator;

public class DrawerClosedPlaying implements State {
    
    private DrawerClosedPlaying() {}

    public static class SingletonHelper {
        private static final DrawerClosedPlaying INSTANCE = new DrawerClosedPlaying();
    }

    public static DrawerClosedPlaying getInstance() {
        return SingletonHelper.INSTANCE;
    }

    @Override
    public void openCloseButtonPushed() {
        DVDPlayer player = DVDPlayer.getInstance();
        player.stop();
        player.open();
        player.changeState(DrawerOpen.getInstance());
    }

    @Override
    public void playButtonPushed() {
        System.out.println("Alredy Playing.");
    }

    @Override
    public void stopButtonPushed() {
        DVDPlayer player = DVDPlayer.getInstance();
        player.stop();
        player.changeState(DrawerClosedNotPlaying.getInstance());
    }
}
