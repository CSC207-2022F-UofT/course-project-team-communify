import Database.playlistLibrary;
import Entities.Playlist;
import Entities.RegularUser;
import Entities.User;
import View.artistView;
import View.loginRegisterView;
import View.playlistView;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    private static final String ICON_BLACK = "src\\main\\java\\View\\assets\\icon_black.png";
    private static final String ICON_RED = "src\\main\\java\\View\\assets\\icon_red.png";
    private static final String LOGO_BLACK = "src\\main\\java\\View\\assets\\logo_black.png";
    private static final String LOGO_RED = "src\\main\\java\\View\\assets\\logo_red.png";

    public static void main(String[] args){

        // Look and Feel Setup
        FlatLightLaf.setup();
        ImageIcon windowIcon = new ImageIcon(ICON_RED);

        // View Initialization
        //new artistView(windowIcon);

//        // TODO
        ArrayList<Integer> p = new ArrayList<>();
        p.add(0);
        p.add(1);

        System.out.println(playlistLibrary.getInstance().findPlaylist(0).getPlaylist().getSongList().size());

        new loginRegisterView();

//        Thread.sleep(5000);

    }
}
