package View;

import ViewModel.PlaylistDsView;
import ViewModel.UserDsView;

import java.util.ArrayList;

/**
 * A view layer data structure to store the user in memory.
 */
public class InMemoryUser implements UserDsView {
    private String username;
    private final ArrayList<InMemoryPlaylist> playlists;

    /**
     * Constructor
     */
    public InMemoryUser(){
        this.playlists = new ArrayList<>();
    }

    /**
     * @param username the username of the user
     */
    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the username of the user
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * @return the playlists of the user
     */
    public ArrayList<InMemoryPlaylist> getPlaylists() {
        return playlists;
    }

    /**
     * @param playlist the playlist to be added to the user
     */
    @Override
    public void addPlaylist(PlaylistDsView playlist) {
        this.playlists.add((InMemoryPlaylist) playlist);
    }

    /**
     * @return a blank playlist
     */
    @Override
    public PlaylistDsView getNewPlaylist(){
        return new InMemoryPlaylist();
    }
}
