package view;

import viewModel.ArtistUserDsView;
/**
 * A view layer data structure to store the artist user in memory.
 */
public class InMemoryArtistUser implements ArtistUserDsView {
    private String username;
    private String name;

    /**
     * @param name the name of the artist
     * @param username the username of the artist
     */
    public InMemoryArtistUser(String name, String username){
        this.name = name;
        this.username = username;
    }

    /**
     * @return the name of the artist
     */
    @Override
    public String getArtistName() {
        return this.name;
    }

    /**
     * @return the username of the artist
     */
    @Override
    public String getUsername() {
        return this.username;
    }

    /**
     * @param username the username of the artist
     */
    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @param artistName the name of the artist
     */
    @Override
    public void setArtistName(String artistName) {
        this.name = artistName;
    }
}
