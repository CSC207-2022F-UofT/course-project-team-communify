package Entities;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Entities layer class representing a Playlist.
 */
public class Playlist {
    private String name;
    private final int id;
    private final User owner;
    private boolean isPublic;
    private final ArrayList<User> collaborators;
    private final LinkedList<Song> songList;

    public Playlist(int id, String name, User owner, boolean isPublic){
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.isPublic = isPublic;
        this.songList = new LinkedList<>();
        collaborators = new ArrayList<>();
    }
    public Playlist(int id, String name, User owner, boolean isPublic, Song firstSong){
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.isPublic = isPublic;
        this.songList = new LinkedList<>();
        this.songList.addFirst(firstSong);
        collaborators = new ArrayList<>();
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
     * @return list of collaborators on this Playlist
     */
    public ArrayList<User> getCollaborators() {
        return this.collaborators;
    }

    /**
     * Removes a given Song from a playlist.
     * @param song Song to be removed
     */
    public void removeSong(Song song){
        this.songList.remove(song);
    }

    /**
     * @return the unique ID of the playlist object
     */
    public int getId() {
        return id;
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