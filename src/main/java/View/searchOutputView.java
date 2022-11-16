package View;

import OutputData.searchOutputData;
import ViewModel.searchViewModel;

import javax.swing.*;
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

        String[][] data = {
                { "Song 1", "Artist 1", " " },
                { "Song 2", "Artist 2", " " },
        };
        String[] columnNames = { "Name", "Artist", "Actions" };
        table = new JTable(data, columnNames);
        table.setBounds(30, 40, 200, 100);
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Add to Space");
        table.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(comboBox));
        this.scrollPane = new JScrollPane(table);
        //scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);





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

    }
}
