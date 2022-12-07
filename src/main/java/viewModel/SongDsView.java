package viewModel;

import java.awt.image.BufferedImage;
/**
 * Interface adapters layer interface for accessing InMemorySong data objects.
 */
public interface SongDsView {
    /**
     * @param name the name of the song
     */
    void setName(String name);

    /**
     * @param cover the cover of the song
     */
    void setCover(BufferedImage cover);

    /**
     * @param id the ID of the song
     */
    void setId(int id);

    /**
     * @param genre the genre of the song
     */
    void setGenre(String genre);

    /**
     * @param artists the artists who made the song
     */
    void setArtists(String[] artists);

    /**
     * @return the ID of the song
     */
    int getId();

    /**
     * @return the artists of the song
     */
    String[] getArtists();

    /**
     * @return the name of the song
     */
    String getName();

    /**
     * @return the genre of the song
     */
    String getGenre();
}
