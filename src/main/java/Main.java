import view.LaunchView;
import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.util.Collections;

/**
 * The driver of the program.
 */
public class Main {


    private static final String ICON_RED = "src/main/java/View/assets/icon_red.png";
    private static final String LOGO_SMALL = "src/main/java/View/assets/logo_red_small.png";
    private static final String LOGO_RED = "src/main/java/View/assets/logo_red.png";

    /**
     * @param args command line arguments
     */
    public static void main(String[] args){

        // Look and Feel Setup
        FlatDarculaLaf.setGlobalExtraDefaults( Collections.singletonMap( "@accentColor", "#ffffff" ) );
        FlatDarculaLaf.setup();

        ImageIcon windowIcon = new ImageIcon(ICON_RED);
        ImageIcon logoRed = new ImageIcon(LOGO_RED);
        ImageIcon logoSmall = new ImageIcon(LOGO_SMALL);

        // FINAL
        new LaunchView(windowIcon, logoRed);

    }
}
