package View;


import Entities.ArtistUser;
import Entities.User;
import ViewModel.EditSongViewModel;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.images.Artwork;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class artistView extends JFrame implements ActionListener {


    private User user;
    private EditSongViewModel esvm;

    private final int FONTSIZE = 10;
    private final int WIDTH = 1280;
    private final int HEIGHT = 640;
    private JFrame jframe;
    private JButton uploadButton;
    private JButton deleteButton;

    private JTable songTable;

    private String[][] tableData = {{"TEST1", "TEST1", "TEST1"}, {"TEST2", "TEST2", "TEST2"}};

    private final String[] COLUMN_NAMES = {"Song", "Artist(s)", "Genre"};

    private final ImageIcon icon;
    private int deleteID;

    public artistView(ImageIcon icon) {
        this.icon = icon;
        this.initializeValues();
        this.initializeComponents();
        this.initializeFrame();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.uploadButton) {

            FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3 Files (*.mp3)", "mp3");
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(filter);

            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                String filepath = String.valueOf(file).replace("\\", "\\\\");

                if(this.esvm.upload(filepath, user.getUsername())){
                    JLabel label = new JLabel("Song Uploaded!", JLabel.CENTER);
                    JOptionPane.showMessageDialog(this, label, "Communify", JOptionPane.PLAIN_MESSAGE);
                    //NEEDS: name, artist, genre, cover. Might need to change upload return... ugh
                }
                else{
                    JLabel label = new JLabel("Upload Unsuccessful.", JLabel.CENTER);
                    JOptionPane.showMessageDialog(this, label, "Communify", JOptionPane.PLAIN_MESSAGE);
                }
            }

        }
        else if(e.getSource() == this.deleteButton && deleteID != -1){
            if(esvm.delete(deleteID)){
                //TODO: Update JFrame, reset deleteID
            }
        }
    }


    private void initializeValues() {
        this.jframe = new JFrame("Communify");
        this.jframe.setSize(this.WIDTH, this.HEIGHT);
        this.jframe.setLocationRelativeTo(null);

        this.jframe.setLayout(null);
        this.jframe.setResizable(false);
        this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jframe.setIconImage(this.icon.getImage());


        this.esvm = new EditSongViewModel();
        this.user = new ArtistUser("TEST", "TEST", "test"); //TODO: REPLACE. TEMPORARY
    }

    private void initializeComponents() {


        this.deleteButton = new JButton();

        this.deleteButton.setBounds(870, 500, 160, 40);
        this.deleteButton.setText("Delete");
        this.deleteButton.setFocusable(false);
        this.deleteButton.setHorizontalTextPosition(JButton.CENTER);

        this.uploadButton = new JButton();

        this.uploadButton.setBounds(1050, 500, 160, 40);
        this.uploadButton.setText("Upload");
        this.uploadButton.setFocusable(false);
        this.uploadButton.setHorizontalTextPosition(JButton.CENTER);


        // Setup JTable
        // ...


        this.uploadButton.addActionListener(this);
        this.deleteButton.addActionListener(this);
    }

    private void initializeFrame() {
        this.jframe.add(uploadButton);
        this.jframe.add(deleteButton);
        this.jframe.setVisible(true);
    }

}