package View;

import OutputData.searchOutputData;
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
    private playlistView playlistView;
    private JScrollPane scrollPane;
    private JLabel title;
    private Font font;
    private int fontSize = 10;
    private int width = 640;
    private int height = 640;

    private JTable table;
    private JComboBox comboBox;
    private String[][] data;

    private searchViewModel searchViewModel;

    public searchOutputView(){
        initialise();
        this.setUpTable();
        this.setVisible();
    }

    public void initialise(){
        this.searchViewModel = new searchViewModel();
        this.jframe = new JFrame("Search Results");
        this.panel = new JPanel();
        this.title = new JLabel("Search results for ");
        this.font = new Font(title.getFont().getName(), Font.PLAIN, this.fontSize);
    }

    public void setUpTable(){
        this.data = this.searchViewModel.search("fo");

        String[] columnNames = {"ID", "Name", "Artist", "Genre"};
        table = new JTable(this.data, columnNames);
        table.setBounds(30, 40, this.width, this.height);
        comboBox = new JComboBox();
        comboBox.addItem("Add to Space");
        comboBox.addItem("Add to Playlist 1");
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.addColumn(new TableColumn());

        for (int i = 0; i < data.length; i++) { // makes the default writing in last column a prompt for combo box
            table.setValueAt("Add to..", i, 4);
        }
        columnModel.getColumn(4).setCellEditor(new DefaultCellEditor(comboBox));
        columnModel.removeColumn(table.getColumnModel().getColumn(0));
        comboBox.addActionListener(this);
        this.scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }

    public void setVisible(){
        // set visible
        this.jframe.setSize(this.width, this.height);
        this.jframe.setResizable(false);
        this.jframe.add(panel);
        this.jframe.add(scrollPane);
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
        }

    }
}
