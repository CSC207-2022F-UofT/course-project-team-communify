package view;


import database.SongLibrary;
import viewModel.ArtistViewModel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;


/**
 * Creates the artist dashboard view.
 */
public class ArtistView extends JFrame implements ActionListener {

    private ArtistViewModel avm;
    private JFrame jframe;
    private JButton uploadButton;
    private JPanel panel;
    private JTable table;
    private final String[] COLUMN_NAMES = {"ID", "Song", "Artist(s)", "Genre"};
    private JLabel welcomeMessage;
    private JLabel logo;
    private final ImageIcon icon;
    private final ImageIcon logoImg;
    private final InMemoryArtistUser user;

    /**
     * @param icon the program icon
     * @param logoImg the program logo
     * @param user the active artist user
     */
    public ArtistView(ImageIcon icon, ImageIcon logoImg, InMemoryArtistUser user) {
        this.icon = icon;
        this.logoImg = logoImg;
        this.user = user;
        this.initializeValues();
        this.initializeComponents();
        this.initializeFrame();
    }


    /**
     * Handles artist dashboard button events.
     * @param e the button press event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.uploadButton){

            FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3 Files (*.mp3)", "mp3");
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(filter);

            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                String filepath = String.valueOf(file).replace("\\", "\\\\");

                if(this.avm.upload(filepath)){
                    JLabel label = new JLabel("Song Uploaded!", JLabel.CENTER);
                    JOptionPane.showMessageDialog(this, label, "Communify", JOptionPane.PLAIN_MESSAGE);
                }
                else{
                    JLabel label = new JLabel("Upload Unsuccessful. Song exists!", JLabel.CENTER);
                    JOptionPane.showMessageDialog(this, label, "Communify", JOptionPane.PLAIN_MESSAGE);
                }
            }
        }
    }


    /**
     * Initializes the values of the main Swing and logic objects.
     */
    private void initializeValues() {

        int WIDTH = 1280;
        int HEIGHT = 640;
        this.jframe = new JFrame("Communify");
        this.jframe.setSize(WIDTH, HEIGHT);
        this.jframe.setLocationRelativeTo(null);

        this.jframe.setLayout(null);
        this.jframe.setResizable(false);
        this.jframe.setIconImage(this.icon.getImage());
        this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        InMemoryArtistUser artist = new InMemoryArtistUser(user.getArtistName(), user.getUsername());
        this.avm = new ArtistViewModel(artist);

        // Init JTable
        String[][] data = this.avm.getArtistSongs();
        this.table = new JTable(data, this.COLUMN_NAMES);
        this.table.setDefaultEditor(Object.class, null);
    }

    /**
     * Initializes Swing related components.
     */
    private void initializeComponents() {

        this.logo = new JLabel(logoImg);
        this.logo.setBounds((this.jframe.getWidth() - logoImg.getIconWidth())/2, 50, logoImg.getIconWidth(), logoImg.getIconHeight());

        this.welcomeMessage = new JLabel("Hey, " + avm.getArtistName() + "!");
        this.welcomeMessage.setFont(UIManager.getFont("h1.font"));
        this.welcomeMessage.setSize(this.welcomeMessage.getPreferredSize());
        this.welcomeMessage.setLocation((this.jframe.getWidth() - welcomeMessage.getWidth())/2, 140);

        this.uploadButton = new JButton();
        this.uploadButton.setBounds(1075, 510, 160, 40);
        this.uploadButton.setText("Upload");
        this.uploadButton.setFocusable(false);
        this.uploadButton.setHorizontalTextPosition(JButton.CENTER);

        // Setup JTable
        this.panel = new JPanel(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(this.table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        panel.setBounds(35, 190, 1200, 300);
        this.panel.add(scrollPane, BorderLayout.CENTER);

        this.uploadButton.addActionListener(this);
        this.jframe.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Since view and SongLibrary are on the same frameworks & drivers layer.
                SongLibrary.getInstance().saveLibrary();
            }
        });
    }

    /**
     * Initializes the main window frame and adds components.
     */
    private void initializeFrame() {
        this.jframe.add(this.uploadButton);
        this.jframe.add(this.logo);
        this.jframe.add(this.welcomeMessage);

        this.jframe.getContentPane().add(panel);
        this.jframe.setVisible(true);
    }

}
