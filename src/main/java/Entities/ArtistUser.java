package Entities;

import java.util.ArrayList;

/**
 * Entity which represents a User which is able to create and own Songs.
 */
public class ArtistUser extends User {
    private final String artistName;
    private final ArrayList<Song> songs;

    /**
     * @param artistName string artist name of the artist
     * @param username string username of the artist
     * @param password string password of the artist
     */
    public ArtistUser(String artistName, String username, String password){
        super(username, password);
        this.artistName = artistName;
        this.songs = new ArrayList<>();
    }

    /**
     * Overloaded constructor for when an Artist owns songs.
     * @param artistName string artist name of the artist
     * @param username string username of the artist
     * @param password string password of the artist
     * @param songs arraylist of songs owned by the artist
     */
    public ArtistUser(String artistName, String username, String password, ArrayList<Song> songs){
        super(username, password);
        this.artistName = artistName;
        this.songs = songs;
    }

    /**
     * @return the library of the Artist's Songs
     */
    public ArrayList<Song> getSongs() {
        return songs;
    }

    /**
     * @return the name of the Artist
     */
    public String getArtistName() {
        return artistName;
    }

    /**
     * Add a new Song to an Artist's library
     * @param s Song to be added to Artist library
     */
    public void addSong(Song s){
        if (!songs.contains(s))
            songs.add(s);
    }

    /**
     * @return String representation used for saving to database
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(artistName + "," + getUsername() + "," + getPassword() + ",");

        for (Song s : songs)
            output.append(s.getID()).append(";");

        if (songs.size() > 0)
            output.deleteCharAt(output.length() - 1);
        return output.toString();
    }
}
