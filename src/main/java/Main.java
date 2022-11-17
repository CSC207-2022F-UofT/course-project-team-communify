import Entities.RegularUser;
import Entities.User;
import View.playlistView;
import View.searchOutputView;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // TODO
        User user = new RegularUser("", "");
        new playlistView(user);
//        new searchOutputView();
        Thread.sleep(5000);

    }
}
