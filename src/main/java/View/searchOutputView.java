package View;

import Database.*;
import ViewModel.musicEngineControllerViewModel;
import ViewModel.playlistViewModel;
import ViewModel.searchViewModel;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    private final ImageIcon icon;

    private final ImageIcon logoImg;

//    private final playlistView playlistView;

    /**
     * @param searchText the search query
     * @param user the logged-in user
     * @param engineVm the view model containing the song data
     * @param pb the current play bar object
     */
    public searchOutputView(String searchText, InMemoryUser user, musicEngineControllerViewModel engineVm,
                            PlayBar pb, ImageIcon icon, ImageIcon logoImg){
        this.icon = icon;
        this.logoImg = logoImg;
        this.musicEngineControllerViewModel = engineVm;
        this.playlistViewModel = new playlistViewModel();
        this.library = songLibrary.getInstance();
        this.playBar = pb;
//        this.playlistView = playlistView;
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
        BorderLayout layout = new BorderLayout(100, 0);
        this.panel = new JPanel(layout);
        this.title = new JLabel(this.searchText);

        this.homeButton = new JButton();
        this.homeButton.setText("Home");
        this.homeButton.setFocusable(false);
        this.homeButton.addActionListener(this);
        this.panel.add(this.playBar.getPanel());
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
        table.setFocusable(false);
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
        comboBox.addItem("Create Playlist");
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
        int WIDTH = 1280;
        this.jframe.setSize(WIDTH, HEIGHT);
        this.jframe.setLocationRelativeTo(null);
        this.jframe.setResizable(false);
        this.jframe.add(title);

        this.panel.add(title, BorderLayout.PAGE_START);
        this.panel.add(scrollPane,BorderLayout.CENTER);
        this.panel.add(homeButton, BorderLayout.PAGE_START);

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
                String playlistConfirmation;
                for (InMemoryPlaylist p : user.getPlaylists()) {
                    if (Objects.equals(p.getName(), playlistToAddTo)) {
                        editedPlaylist = p;
                        int songID = Integer.parseInt(ids[row]);
                        playlistConfirmation = this.playlistViewModel.callAddSong(user, p, songID);
                        this.createPopup(playlistConfirmation);
                        break;
                    }
                }
                if (editedPlaylist != null){
                    this.user.removePlaylist(editedPlaylist);
                    this.user.addPlaylist(this.playlistViewModel.getCurrPlaylist());
                }

            }
            if(this.comboBox.getSelectedItem().toString().equals("Create Playlist")){
                int songID = Integer.parseInt(ids[row]);
                playlistView view = new playlistView(this.user, this.musicEngineControllerViewModel,
                                this.playBar, this.icon, this.logoImg);
                this.jframe.dispose();
                new NewPlaylistInputDataView(this.user,view,songID);
                System.out.println(songID);
            }
            //TODO: create playlist w/ one song
        }
        if (e.getSource() == this.homeButton) {
            this.jframe.dispose();
            new playlistView(this.user, this.musicEngineControllerViewModel, this.playBar, this.icon, this.logoImg);
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
