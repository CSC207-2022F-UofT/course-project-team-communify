package Entities;

import java.util.ArrayList;
import java.util.LinkedList;

public class Playlist {
    private String name;
    private User owner;
    private boolean isPublic;
    private LinkedList<Song> songList;

    public Playlist(String name, User owner, boolean isPublic, Song firstSong){
        this.name = name;
        this.owner = owner;
        this.isPublic = isPublic;
        this.songList.addFirst(firstSong);
    }

    public void setName(String name){
        this.name = name;

    }
    public String getName(){
        return this.name;
    }
    // no set owner because the owner is permenantly set upon intilization

    public User getOwner(){
        return this.owner;
    }

    public void setPrivacy(boolean privacy){
        this.isPublic = privacy;
    }

    public boolean returnPrivacy(){
        return this.isPublic;
    }
}
