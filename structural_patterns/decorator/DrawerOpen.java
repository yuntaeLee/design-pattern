package structural_patterns.decorator;

public class DrawerOpen implements State {

    private DrawerOpen() {}

    private static class SingletonHelper {
        private static final DrawerOpen INSTANCE = new DrawerOpen();
    }

    public static DrawerOpen getInstance() {
        return SingletonHelper.INSTANCE;
    }

    @Override
    public void openCloseButtonPushed() {
        DVDPlayer player = DVDPlayer.getInstance();
        player.close();
        player.changeState(DrawerOpen.getInstance());
    }

    @Override
    public void playButtonPushed() {
        DVDPlayer player = DVDPlayer.getInstance();
        player.close();
        player.changeState(DrawerClosedNotPlaying.getInstance());
        player.play();
        player.changeState(DrawerClosedPlaying.getInstance());
    }

    @Override
    public void stopButtonPushed() {
        System.out.println("Do Nothing as DVDPlayer is open you pushed stop.");
    }
}
