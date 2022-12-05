package view;

import viewModel.PlaylistViewModel;
import viewModel.SearchViewModel;

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
public class SearchOutputView extends JFrame implements ActionListener {

    private static final ImageIcon BACK = new ImageIcon("src/main/java/view/assets/button/back.png");
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
    private SearchViewModel searchViewModel;
    private final viewModel.MusicEngineViewModel musicEngineViewModel;
    private final PlaylistViewModel playlistViewModel;
    private JPanel topBar;
    private final PlayBar playBar;
    private final ImageIcon icon;
    private final ImageIcon logoImg;
    private final PlaylistView playlistView;
    private final int WIDTH = 1280;

    /**
     * @param searchText the search query
     * @param user the logged-in user
     * @param engineVm the view model containing the song data
     * @param pb the current play bar object
     * @param icon the icon object
     * @param logoImg the logo object
     * @param playlistView the main window
     */
    public SearchOutputView(String searchText, InMemoryUser user, viewModel.MusicEngineViewModel engineVm,
                            PlayBar pb, ImageIcon icon, ImageIcon logoImg, PlaylistView playlistView){
        this.icon = icon;
        this.logoImg = logoImg;
        this.musicEngineViewModel = engineVm;
        this.playlistViewModel = new PlaylistViewModel();
        this.playBar = pb;
        this.playlistView = playlistView;
        this.initialiseValues(searchText, user);
        this.setUpTable();
        this.initializeFrame();
    }

    /**
     * @param searchText the search query
     * @param user the logged-in user
     */
    public void initialiseValues(String searchText, InMemoryUser user){

        Dimension DEFAULT_SIZE = new Dimension(50, 50);
        int DEFAULT_KERNING = 20;

        this.searchViewModel = new SearchViewModel();
        this.user = user;
        this.searchText = searchText;
        this.jframe = new JFrame("Search Results");
        BorderLayout layout = new BorderLayout(100, 0);
        this.panel = new JPanel(layout);

        this.homeButton = new JButton(BACK);
        this.homeButton.setPreferredSize(DEFAULT_SIZE);
        this.homeButton.setFocusable(false);
        this.homeButton.setOpaque(false);
        this.homeButton.setBorderPainted(false);
        this.homeButton.setContentAreaFilled(false);
        this.homeButton.addActionListener(this);

        this.title = new JLabel();
        if(searchText.equals("")) this.title.setText("Showing All Songs:");
        else this.title.setText("Showing Search Results For \"" + searchText + "\":");

        this.title.setFont(UIManager.getFont( "h2.regular" ));
        this.title.setBounds(DEFAULT_SIZE.width + DEFAULT_KERNING, DEFAULT_KERNING/3, this.WIDTH - DEFAULT_SIZE.width, DEFAULT_SIZE.height);

        this.topBar = new JPanel();
        FlowLayout topLayout = new FlowLayout(FlowLayout.LEFT);
        this.topBar.setLayout(topLayout);

        this.topBar.add(this.homeButton);
        this.topBar.add(this.title);
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

        this.jframe = new JFrame("Communify");
        this.jframe.setIconImage(this.icon.getImage());
        this.jframe.setSize(WIDTH, HEIGHT);
        this.jframe.setLocationRelativeTo(null);
        this.jframe.setResizable(false);
        this.jframe.add(title);

        this.panel.add(topBar, BorderLayout.NORTH);
        this.panel.add(scrollPane,BorderLayout.CENTER);

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
            String item = "";
            if (this.comboBox.getSelectedItem() != null){
                item = this.comboBox.getSelectedItem().toString();
            }
            System.out.println(item);
            int row = this.table.getSelectedRow();
            System.out.println(ids[row]);

            if (item.equals("Add to Space")) {
                String PopupMessage = this.musicEngineViewModel.callAddToSpace(Integer.parseInt(ids[row]));
                this.createPopup(PopupMessage);
            }
            if (this.comboBox.getSelectedItem().toString().equals("Play Song")) {
                this.musicEngineViewModel.playSongAction(Integer.parseInt(ids[row]));
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
                    this.user.addPlaylist(this.playlistViewModel.getCurrPlaylist(), false);
                }

            }
            if(this.comboBox.getSelectedItem().toString().equals("Create Playlist")){
                int songID = Integer.parseInt(ids[row]);
                new NewPlaylistInputDataView(this.user,this.playlistView,songID);

                System.out.println(songID);
            }
        }
        if (e.getSource() == this.homeButton) {
            this.jframe.dispose();
            new PlaylistView(this.user, this.musicEngineViewModel, this.playBar, this.icon, this.logoImg);
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
