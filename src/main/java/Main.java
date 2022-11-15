import Entities.RegularUser;
import Entities.User;
import View.playlistView;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // TODO
        User user = new RegularUser("", "");
        new playlistView(user);
        Thread.sleep(5000);

    }
}
