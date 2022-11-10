package Entities;

public class userFactory {
    public User createRegularUser(String username, String password){
        return new RegularUser(username, password);
    }
    public User createArtistUser(String artistName, String username, String password){
        return new ArtistUser(artistName, username, password);
    }
}
