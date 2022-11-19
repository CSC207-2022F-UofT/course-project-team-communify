import Entities.RegularUser;
import Entities.User;
import View.playlistView;
import View.searchOutputView;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // TODO
        User user = new RegularUser("", "");
        playlistView PlaylistView = new playlistView(user);
        new searchOutputView(PlaylistView);
        Thread.sleep(5000);

    }
}
