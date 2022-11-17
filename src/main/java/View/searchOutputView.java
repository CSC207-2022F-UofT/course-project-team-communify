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

    private final searchViewModel searchViewModel;

    public searchOutputView(){
        this.searchViewModel = new searchViewModel();

        this.jframe = new JFrame("Search Results");
        this.panel = new JPanel();
        this.title = new JLabel("Search results for ");
        this.font = new Font(title.getFont().getName(), Font.PLAIN, this.fontSize);


        // set up panel
//        panel.setLayout(null);
//        panel.setBounds(0,0, this.width, this.height);  // TODO: probably want this to be larger
        // panel.setBackground(Color.BLUE);

//        String[][] data = {
//                { "Song 1", "Artist 1", " " },
//                { "Song 2", "Artist 2", " " },
//        };
        String[][] data = this.searchViewModel.search("stalin's head");

        String[] columnNames = {"ID", "Name", "Artist", "Genre"};
        table = new JTable(data, columnNames);
        table.setBounds(30, 40, this.width, this.height);
        comboBox = new JComboBox();
        comboBox.addItem("Add to Space");
        comboBox.addItem("Add to Playlist 1");
        TableColumnModel tableModel = table.getColumnModel();
        tableModel.addColumn(new TableColumn());

        for (int i = 0; i < data.length; i++) { // makes the default writing in 4th column a prompt
            table.setValueAt("Add to..", i, 4);
        }

        table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(comboBox));
        table.getColumnModel().removeColumn(table.getColumnModel().getColumn(0));
        comboBox.addActionListener(this);
        this.scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);





        // set visible
        this.jframe.setSize(this.width, this.height);
//        this.jframe.setResizable(false);
        // this.panel.add(title);
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
