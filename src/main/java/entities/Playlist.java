package entities;

import java.util.LinkedList;

/**
 * Entities layer class representing a Playlist.
 *
 */
public class Playlist {
    private final String name;
    private final int id;
    private final User owner;
    private final LinkedList<Song> songList;

    /**
     * @param id int id of the playlist
     * @param name string name of the playlist
     * @param owner User who owns the playlist
     */
    public Playlist(int id, String name, User owner){
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.songList = new LinkedList<>();
    }

    /**
     * Overloaded constructor for playlists with a first song
     * @param id int id of the playlist
     * @param name string name of the playlist
     * @param owner User who owns the playlist
     * @param firstSong the first Song in the playlist
     */
    public Playlist(int id, String name, User owner, Song firstSong){
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.songList = new LinkedList<>();
        this.songList.add(firstSong);
        //this.songList.addFirst(firstSong);
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
