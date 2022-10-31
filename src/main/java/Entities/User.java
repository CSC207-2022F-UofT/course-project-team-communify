package Entities;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private final String username;
    private final String password;
    private final List<Playlist> playlistList;
    public User(String u, String p, ArrayList<Playlist> playlists){
        this.password = p;
        this.username = u;
        this.playlistList = playlists;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public List<Playlist> getPlaylistList() {
        return playlistList;
    }
}
