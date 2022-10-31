package Entities;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private String Username;
    private String password;
    List<Playlist> playlistList = new ArrayList<Playlist>();

    public String getUsername() {
        return Username;
    }
    public String getPassword() {
        return password;
    }
    public List<Playlist> getPlaylistList() {
        return playlistList;
    }
}
