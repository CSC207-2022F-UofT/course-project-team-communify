import View.artistView;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;

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
        new artistView(windowIcon);

//        // TODO
//        User user = new RegularUser("User", "");
//        new playlistView(user);
//        Thread.sleep(5000);

    }
}
