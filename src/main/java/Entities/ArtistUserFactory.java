package Entities;

public class ArtistUserFactory implements userFactory{

    @Override
    public User createUser(String artistName, String username, String password) {
        return new ArtistUser(artistName, username, password);
    }
}
