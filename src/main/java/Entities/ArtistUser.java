package Entities;

import java.util.ArrayList;

/**
 * Entity which represents a User which is able to create and own Songs.
 */
public class ArtistUser extends User {
    private final String artistName;
    private final ArrayList<Song> songs;

    public ArtistUser(String artistName, String username, String password){
        super(username, password);
        this.artistName = artistName;
        this.songs = new ArrayList<>();
    }

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
        StringBuilder output = new StringBuilder(getUsername() + "," + getPassword() + "," + artistName + ",");

        for (Song s : songs)
            output.append(s.getID()).append(";");

        if (songs.size() > 0)
            output.deleteCharAt(output.length() - 1);
        return output.toString();
    }
}
