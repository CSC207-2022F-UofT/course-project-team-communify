package view;

import viewModel.PlaylistDsView;
import viewModel.UserDsView;

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
    @Override
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
     * @param first if the playlist should be added first
     */
    @Override
    public void addPlaylist(PlaylistDsView playlist, boolean first) {
        if (first)
            this.playlists.add(0, (InMemoryPlaylist) playlist);
        else
            this.playlists.add((InMemoryPlaylist) playlist);
    }

    /**
     * @return a blank playlist
     */
    @Override
    public PlaylistDsView getNewPlaylist(){
        return new InMemoryPlaylist();
    }

    /**
     * @param p the playlist to remove from the user
     */
    public void removePlaylist(InMemoryPlaylist p) {
        this.playlists.remove(p);
    }
}
