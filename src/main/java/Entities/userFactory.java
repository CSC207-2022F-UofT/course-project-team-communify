package Entities;

import java.util.ArrayList;

public class userFactory {
    public User createRegularUser(String username, String password){
        return new RegularUser(username, password);
    }

    public User createRegularUser(String username, String password, ArrayList<Integer> playlist) {
        return new RegularUser(username, password, playlist);
    }

    public User createArtistUser(String artistName, String username, String password){
        return new ArtistUser(artistName, username, password);
    }

    public User createArtistUser(String artistName, String username, String password, ArrayList<Song> songs){
        return new ArtistUser(artistName, username, password, songs);
    }
}
