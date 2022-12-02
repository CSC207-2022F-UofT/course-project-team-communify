package Entities;

import java.util.ArrayList;

/**
 * An implementation of a pseudo-factory design pattern entity to produce Users of multiple subtypes
 */
public class UserFactory {
    /**
     * Method to create a regular user with no playlists
     * @param username username of the new user
     * @param password password of the new user
     * @return the new RegularUser
     */
    public User createRegularUser(String username, String password){
        return new RegularUser(username, password);
    }

    /**
     * Method to create a regular user with playlists
     * @param username username of the new user
     * @param password password of the new user
     * @param playlist the list of playlist IDs owned by this User
     * @return the new RegularUser
     */
    public User createRegularUser(String username, String password, ArrayList<Integer> playlist) {
        return new RegularUser(username, password, playlist);
    }

    /**
     * Method to create an artist user with no songs
     * @param username username of the new user
     * @param password password of the new user
     * @param artistName the artist name of this ArtistUser
     * @return the new ArtistUser
     */
    public User createArtistUser(String artistName, String username, String password){
        return new ArtistUser(artistName, username, password);
    }

    /**
     * Method to create an artist user with songs
     * @param username username of the new user
     * @param password password of the new user
     * @param songs the list of Songs owned by this Artist
     * @param artistName the artist name of this ArtistUser
     * @return the new ArtistUser
     */
    public User createArtistUser(String artistName, String username, String password, ArrayList<Song> songs){
        return new ArtistUser(artistName, username, password, songs);
    }
}
