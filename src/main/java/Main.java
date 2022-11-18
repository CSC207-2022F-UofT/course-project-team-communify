import Entities.RegularUser;
import Entities.User;
import View.artistView;
import Entities.RegularUser;
import View.loginRegisterView;
import View.playlistView;

public class Main {

    public static void main(String[] args) throws InterruptedException {

          new loginRegisterView();
        String username = "test user";
        String password = "test password";
        RegularUser User = new RegularUser(username, password);
        new playlistView(User);

//        // TODO
//        User user = new RegularUser("User", "");
//        new playlistView(user);
//        Thread.sleep(5000);

    }
}
