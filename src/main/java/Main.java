import database.SongLibrary;
import view.LaunchView;
import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.util.Collections;

/**
 * The driver of the program.
 */
public class Main {

    private static final String ICON_RED = "src/main/java/view/assets/icon_red.png";
    private static final String LOGO_RED = "src/main/java/view/assets/logo_red.png";

    /**
     * @param args command line arguments
     */
    public static void main(String[] args){

        // Look and Feel Setup
        FlatDarculaLaf.setGlobalExtraDefaults( Collections.singletonMap( "@accentColor", "#ffffff" ) );
        FlatDarculaLaf.setup();

        ImageIcon windowIcon = new ImageIcon(ICON_RED);
        ImageIcon logoRed = new ImageIcon(LOGO_RED);

        // initialization of the song library
        SongLibrary instance = SongLibrary.getInstance();
        assert instance != null;

        // FINAL
        new LaunchView(windowIcon, logoRed);

    }
}
