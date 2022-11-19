package View;


import Entities.RegularUser;
import ViewModel.searchViewModel;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class searchOutputView extends JFrame implements ActionListener {

    private JFrame jframe;
    private JPanel panel;
    private JScrollPane scrollPane;
    private JLabel title;
    private JButton homeButton;
    private Font font;
    private int FONTSIZE = 10;
    private int width = 640;
    private int height = 640;

    private JTable table;
    private BorderLayout layout;
    private JComboBox comboBox;
    private String[][] data;
    private String[] ids;

    private searchViewModel searchViewModel;
    private String searchText;

    public searchOutputView(String searchText){
        initialise(searchText);
        this.setUpTable();
        this.setVisible();
    }

    public void initialise(String searchText){
        this.searchViewModel = new searchViewModel();
        this.searchText = searchText;
        this.jframe = new JFrame("Search Results");
        this.layout = new BorderLayout(30, 30);
        this.panel = new JPanel(layout);
        this.title = new JLabel("Search results for " + this.searchText);
        this.font = new Font(title.getFont().getName(), Font.PLAIN, this.FONTSIZE);
        this.title.setFont(new Font(title.getFont().getName(), Font.PLAIN, this.FONTSIZE * 2));

        this.homeButton = new JButton();
        this.homeButton.setText("Home");
        this.homeButton.setFocusable(false);
        this.homeButton.setHorizontalTextPosition(JButton.CENTER);
        this.homeButton.setForeground(Color.black);
        this.homeButton.setBackground(Color.lightGray);
        this.homeButton.addActionListener(this);
    }

    public void setUpTable(){
        this.data = this.searchViewModel.search(this.searchText);

        String[][] formattedData = new String[data.length][3];
        this.ids = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            this.ids[i] = data[i][0];
            System.arraycopy(data[i], 1, formattedData[i], 0, 3);
        }

        String[] columnNames = {"ID", "Name", "Artist", "Genre"};
        table = new JTable(this.data, columnNames);
        TableColumnModel columnModel = table.getColumnModel();
        setUpActions(columnModel, formattedData);

        columnModel.removeColumn(table.getColumnModel().getColumn(0));
        comboBox.addActionListener(this);
        this.scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }

    public void setUpActions(TableColumnModel columnModel, String[][] formattedData){
        comboBox = new JComboBox();
        comboBox.addItem("Add to Space");
        comboBox.addItem("Add to Playlist 1");
        //TODO: get Playlist names and make this dynamic

        columnModel.addColumn(new TableColumn());

        // make the default writing in last column a prompt for combo box
        for (int i = 0; i < formattedData.length; i++) {
            table.setValueAt("Add to..", i, 4);
        }
        columnModel.getColumn(4).setCellEditor(new DefaultCellEditor(comboBox));
    }

    public void setVisible(){
        this.jframe.setSize(this.width, this.height);
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
        if (e.getSource() == this.comboBox){

            System.out.println(this.comboBox.getSelectedItem().toString());
            int row = this.table.getSelectedRow();
            System.out.println(ids[row]);
            //TODO: pass id to play space or add to playlist

        } else if (e.getSource()  == this.homeButton) {
            this.jframe.dispose();
            new playlistView(new RegularUser("",""));
            // TODO: make this into an actual user
        }

    }
}
