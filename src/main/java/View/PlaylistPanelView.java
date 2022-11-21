package View;

import ViewModel.musicEngineControllerViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PlaylistPanelView implements ActionListener {
    private final int WIDTH = 600;
    private final int HEIGHT = 400;
    private JPanel panel;
    private JScrollPane pane;
    private ArrayList<IDButton> buttons;
    private musicEngineControllerViewModel viewModel;

    public PlaylistPanelView(InMemoryUser u, musicEngineControllerViewModel vm){
        initializeComponents(u.getPlaylists(), vm);
    }

    private void initializeComponents(ArrayList<InMemoryPlaylist> playlistList, musicEngineControllerViewModel vm) {
        this.viewModel = vm;
        this.panel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(this.panel, BoxLayout.Y_AXIS);
        this.panel.setLayout(boxLayout);
        panel.setBounds(0, 0, WIDTH, HEIGHT);
        this.pane = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pane.setBounds(15, 120, WIDTH, HEIGHT);

        this.buttons = new ArrayList<>();
        for (InMemoryPlaylist p : playlistList){
            JPanel mainPanel = new JPanel();
            BoxLayout playlistLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
            mainPanel.setLayout(playlistLayout);

            JPanel namePanel = new JPanel();
            FlowLayout nameLayout = new FlowLayout(FlowLayout.CENTER, 20, 0);
            namePanel.setLayout(nameLayout);
            JLabel name = new JLabel(p.getName());
            name.setFont(new Font("Segoe UI", Font.BOLD, 36));
            IDButton button = new IDButton(p.getId());
            button.addActionListener(this);
            button.setText("Play");
            namePanel.add(name);
            namePanel.add(button);
            this.buttons.add(button);
            mainPanel.add(namePanel);

            JPanel songPanel = new JPanel();
            GridLayout songLayout = new GridLayout(p.getSongs().size(), 4);
            songLayout.setVgap(10);
            songLayout.setHgap(0);
            songPanel.setLayout(songLayout);
            for (InMemorySong s : p.getSongs()){
                JPanel thisSongPanel = new JPanel();
                FlowLayout thisSongLayout = new FlowLayout(FlowLayout.LEFT, 15, 0);
                thisSongPanel.setLayout(thisSongLayout);
                JLabel cover = new JLabel(new ImageIcon(s.getCover().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
                JLabel songName = new JLabel(s.getName());
                JLabel artists = new JLabel(String.join(", ", s.getArtists()));
                JLabel genre = new JLabel(s.getGenre());
                thisSongPanel.add(cover);
                thisSongPanel.add(songName);

                songPanel.add(thisSongPanel);
                songPanel.add(artists);
                songPanel.add(genre);
            }
            mainPanel.add(songPanel);
            this.panel.add(mainPanel);
        }
    }

    public JScrollPane getPane() {
        return pane;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (buttons.contains((IDButton) actionEvent.getSource())){
            int id = buttons.indexOf((IDButton) actionEvent.getSource());
            viewModel.playPlaylistAction(buttons.get(id).getId());
        }
    }
}