package structural_patterns.decorator;

public class DrawerClosedNotPlaying implements State {

    private DrawerClosedNotPlaying() {}

    private static class SingletonHelper {
        private static final DrawerClosedNotPlaying INSTANCE = new DrawerClosedNotPlaying();
    }

    public static DrawerClosedNotPlaying getInstance() {
        return SingletonHelper.INSTANCE;
    }

    @Override
    public void openCloseButtonPushed() {
        DVDPlayer player = DVDPlayer.getInstance();
        player.open();
        player.changeState(DrawerOpen.getInstance());
    }

    @Override
    public void playButtonPushed() {
        DVDPlayer player = DVDPlayer.getInstance();
        player.play();
        player.changeState(DrawerClosedPlaying.getInstance());
    }

    @Override
    public void stopButtonPushed() {
        System.out.println("Already not playing anything.");
    }
}
