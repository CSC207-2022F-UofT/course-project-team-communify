package Entities;

import java.util.LinkedList;

/**
 * Entities layer class representing a Playlist.
 */
public class Playlist {
    private String name;
    private final User owner;
    private boolean isPublic;
    private final LinkedList<Song> songList;

    public Playlist(String name, User owner, boolean isPublic){
        this.name = name;
        this.owner = owner;
        this.isPublic = isPublic;
        this.songList =  new LinkedList<Song>();
    }

    /**
     * @param name Desired name of Playlist
     */
    public void setName(String name){
        this.name = name;

    }

    /**
     * @return name of Playlist
     */
    public String getName(){
        return this.name;
    }
    // no set owner because the owner is permanently set upon initialization

    /**
     * @return User object representing owner of a playlist
     */
    public User getOwner(){
        return this.owner;
    }

    /**
     * @param privacy true if and only if the Playlist is desired to be public
     */
    public void setPrivacy(boolean privacy){
        this.isPublic = privacy;
    }

    /**
     * @return true if and only if the Playlist is public
     */
    public boolean returnPrivacy(){
        return this.isPublic;
    }

    /**
     * Adds a single Song object to the Playlist.
     * @param newSong Song object to be added to the Playlist
     */
    public void addSong(Song newSong){
        this.songList.add(newSong);
    }

    /**
     * @return the list of Song objects in the Playlist
     */
    public LinkedList<Song> getSongList() {
        return songList;
    }
}
