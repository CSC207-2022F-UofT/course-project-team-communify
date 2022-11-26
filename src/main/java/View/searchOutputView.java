package View;

import Database.*;
import Entities.Playlist;
import Entities.Song;
import ViewModel.musicEngineControllerViewModel;
import ViewModel.playlistViewModel;
import ViewModel.searchViewModel;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * view for search output
 */
public class searchOutputView extends JFrame implements ActionListener {
    private InMemoryUser user;
    private String searchText;
    private JFrame jframe;
    private JPanel panel;
    private JScrollPane scrollPane;
    private JLabel title;
    private JButton homeButton;
    private JTable table;
    private JComboBox<String> comboBox;
    private String[] ids;
    private searchViewModel searchViewModel;
    private final musicEngineControllerViewModel musicEngineControllerViewModel;
    private final playlistViewModel playlistViewModel;

    private final GetSongAccessInterface library;

    private final PlayBar playBar;

    /**
     * @param searchText the search query
     * @param user the logged-in user
     * @param engineVm the view model containing the song data
     * @param pb the current play bar object
     */
    public searchOutputView(String searchText, InMemoryUser user, musicEngineControllerViewModel engineVm, PlayBar pb){
        this.musicEngineControllerViewModel = engineVm;
        this.playlistViewModel = new playlistViewModel();
        this.library = songLibrary.getInstance();
        this.playBar = pb;
        this.initialiseValues(searchText, user);
        this.setUpTable();
        this.initializeFrame();
    }

    /**
     * @param searchText the search query
     * @param user the logged-in user
     */
    public void initialiseValues(String searchText, InMemoryUser user){
        this.searchViewModel = new searchViewModel();
        this.user = user;
        this.searchText = searchText;
        this.jframe = new JFrame("Search Results");
        BorderLayout layout = new BorderLayout(30, 30);
        this.panel = new JPanel(layout);
        this.title = new JLabel("Search results for " + this.searchText);
        int FONTSIZE = 10;
        this.title.setFont(new Font(title.getFont().getName(), Font.PLAIN, FONTSIZE * 2));

        this.homeButton = new JButton();
        this.homeButton.setText("Home");
        this.homeButton.setFocusable(false);
        this.homeButton.setHorizontalTextPosition(JButton.CENTER);
        this.homeButton.setForeground(Color.black);
        this.homeButton.setBackground(Color.white);
        this.homeButton.addActionListener(this);
    }


    /**
     * Method to set up JTable in View that outputs search results
     */
    public void setUpTable(){
        String[][] data = this.searchViewModel.search(this.searchText);

        String[][] formattedData = new String[data.length][3];
        this.ids = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            this.ids[i] = data[i][0];
            System.arraycopy(data[i], 1, formattedData[i], 0, 3);
        }

        String[] columnNames = {"ID", "Name", "Artist", "Genre"};
        table = new JTable(data, columnNames);
        TableColumnModel columnModel = table.getColumnModel();
        setUpActions(columnModel, formattedData.length);
        columnModel.removeColumn(table.getColumnModel().getColumn(0));
        comboBox.addActionListener(this);
        this.scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }

    /**
     * Helper function for setUpTable.
     * Makes the Actions column in the JTable
     * @param columnModel is the Column Model of the JTable
     * @param length is the length of the formatted data
     */
    public void setUpActions(TableColumnModel columnModel, int length){
        comboBox = new JComboBox<>();
        comboBox.addItem("Play Song");
        comboBox.addItem("Add to Space");

        for (InMemoryPlaylist p : user.getPlaylists()) {
            comboBox.addItem("Add to " + p.getName());
        }

        columnModel.addColumn(new TableColumn());

        // make the default writing in last column a prompt for combo box
        for (int i = 0; i < length; i++) {
            table.setValueAt("Add to..", i, 4);
        }
        columnModel.getColumn(4).setCellEditor(new DefaultCellEditor(comboBox));
    }

    /**
     * Initializes the main window frame and adds components.
     */
    public void initializeFrame(){
        int HEIGHT = 640;
        int WIDTH = 640;
        this.jframe.setSize(WIDTH, HEIGHT);
        this.jframe.setResizable(false);
        this.jframe.add(title);

        this.panel.add(title, BorderLayout.PAGE_START);
        this.panel.add(scrollPane,BorderLayout.CENTER);
        this.panel.add(homeButton, BorderLayout.PAGE_END);
        this.panel.setBackground(new Color(156, 219, 250));

        this.jframe.add(panel);
        this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jframe.setVisible(true);

    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.comboBox) {
            System.out.println(this.comboBox.getSelectedItem().toString());
            int row = this.table.getSelectedRow();
            System.out.println(ids[row]);

            if (this.comboBox.getSelectedItem().toString().equals("Add to Space")) {
                String PopupMessage = this.musicEngineControllerViewModel.callAddToSpace(Integer.parseInt(ids[row]));
                this.createPopup(PopupMessage);
            }
            if (this.comboBox.getSelectedItem().toString().equals("Play Song")) {
                this.musicEngineControllerViewModel.playSongAction(Integer.parseInt(ids[row]));
            }
            if (this.comboBox.getSelectedItem().toString().contains("Add to ")) {
                String playlistToAddTo = this.comboBox.getSelectedItem().toString().
                        replace("Add to ", "");
                InMemoryPlaylist editedPlaylist = null;
                for (InMemoryPlaylist p : user.getPlaylists()) {
                    if (Objects.equals(p.getName(), playlistToAddTo)) {
                        editedPlaylist = p;
                        int songID = Integer.parseInt(ids[row]);
                        this.playlistViewModel.callAddSong(user, p, songID);
                        break;
                    }
                }
                if (editedPlaylist != null){
                    this.user.removePlaylist(editedPlaylist);
                    this.user.addPlaylist(this.playlistViewModel.getCurrPlaylist());
                }
            }
        }
        if (e.getSource() == this.homeButton) {
            this.jframe.dispose();
            new playlistView(this.user, this.musicEngineControllerViewModel, this.playBar);
        }
    }

    /**
     * @param text the text to show in the popup
     */
    private void createPopup(String text){
        JOptionPane pane = new JOptionPane(null);
        pane.setMessage(text);
        JDialog dialog = pane.createDialog(null, text);
        dialog.setVisible(true);
    }

}
