package View;


import Database.songLibrary;
import Entities.ArtistUser;
import ViewModel.ArtistViewModel;

import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;


public class artistView extends JFrame implements ActionListener {

    private ArtistViewModel avm;
    private final int WIDTH = 1280;
    private final int HEIGHT = 640;
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

    public artistView(ImageIcon icon, ImageIcon logoImg, InMemoryArtistUser user) {
        this.icon = icon;
        this.logoImg = logoImg;
        this.user = user;
        this.initializeValues();
        this.initializeComponents();
        this.initializeFrame();
    }


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
                    JLabel label = new JLabel("Upload Unsuccessful.", JLabel.CENTER);
                    JOptionPane.showMessageDialog(this, label, "Communify", JOptionPane.PLAIN_MESSAGE);
                }
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


        InMemoryArtistUser artist = new InMemoryArtistUser(user.getArtistName(), user.getUsername());
        this.avm = new ArtistViewModel(artist);

        // Init JTable
        String[][] data = this.avm.getArtistSongs();
        this.table = new JTable(data, this.COLUMN_NAMES);
        this.table.setDefaultEditor(Object.class, null);
    }

    private void initializeComponents() {

        this.logo = new JLabel(logoImg);
        this.logo.setBounds((this.jframe.getWidth() - logoImg.getIconWidth())/2, 50, logoImg.getIconWidth(), logoImg.getIconHeight());

        this.welcomeMessage = new JLabel("Hey, " + avm.getArtistName() + "!");
        this.welcomeMessage.setFont(new Font(this.welcomeMessage.getFont().getName(), Font.PLAIN, 24));
        this.welcomeMessage.setSize(this.welcomeMessage.getPreferredSize());
        this.welcomeMessage.setLocation((this.jframe.getWidth() - welcomeMessage.getWidth())/2, 130);

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
                songLibrary.getInstance().saveLibrary();
            }
        });
    }

    private void initializeFrame() {
        this.jframe.add(this.uploadButton);
        this.jframe.add(this.logo);
        this.jframe.add(this.welcomeMessage);

        this.jframe.getContentPane().add(panel);
        this.jframe.setVisible(true);
    }

}
