package View;

import ViewModel.PlaylistDsView;
import ViewModel.UserDsView;

import java.util.ArrayList;

public class InMemoryUser implements UserDsView {
    private String username;
    private final ArrayList<InMemoryPlaylist> playlists;

    public InMemoryUser(){
        this.playlists = new ArrayList<>();
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public ArrayList<InMemoryPlaylist> getPlaylists() {
        return playlists;
    }

    @Override
    public void addPlaylist(PlaylistDsView playlist) {
        this.playlists.add((InMemoryPlaylist) playlist);
    }

    @Override
    public PlaylistDsView getNewPlaylist(){
        return new InMemoryPlaylist();
    }
}
