package Entities;

import java.util.LinkedList;

/**
 * Entities layer class representing a Playlist.
 * TODO Edge Case: song is removed while its being played should not affect the songs being played, or playlists
 */
public class Playlist {
    private String name;
    private final int id;
    private final User owner;
    private final LinkedList<Song> songList;

    public Playlist(int id, String name, User owner){
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.songList = new LinkedList<Song>();
    }
    
    public Playlist(int id, String name, User owner, Song firstSong){
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.songList = new LinkedList<Song>();
        this.songList.addFirst(firstSong);
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

    /**
     * @return User object representing owner of a playlist
     */
    public User getOwner(){
        return this.owner;
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
