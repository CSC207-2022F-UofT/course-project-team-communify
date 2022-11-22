package ViewModel;

/**
 * Interface adapters layer interface for accessing InMemoryArtistUser data objects.
 */
public interface ArtistUserDsView {

    /**
     * @return the name of the artist
     */
    String getArtistName();

    /**
     * @return the username of the artist
     */
    String getUsername();

    /**
     * @param username the username of the artist
     */
    void setUsername(String username);

    /**
     * @param artistName the name of the artist
     */
    void setArtistName(String artistName);
}
