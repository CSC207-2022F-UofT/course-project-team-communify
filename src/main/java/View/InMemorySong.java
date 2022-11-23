package View;

import ViewModel.SongDsView;

import java.awt.image.BufferedImage;
/**
 * A view layer data structure to store the song in memory.
 */
public class InMemorySong implements SongDsView {
    private String name;
    private BufferedImage cover;
    private String[] artists;
    private String genre;
    private int id;

    /**
     * Empty constructor.
     */
    public InMemorySong(){
        this.name = "";
    }

    /**
     * @param name the name of the song
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param cover the cover of the song
     */
    @Override
    public void setCover(BufferedImage cover) {
        this.cover = cover;
    }

    /**
     * @param id the ID of the song
     */
    @Override
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param genre the genre of the song
     */
    @Override
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * @param artists the artists who made the song
     */
    @Override
    public void setArtists(String[] artists) {
        this.artists = artists;
    }

    /**
     * @return the ID of the song
     */
    public int getId() {
        return id;
    }

    /**
     * @return the cover of the song
     */
    public BufferedImage getCover() {
        return cover;
    }

    /**
     * @return the genre of the song
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @return the name of the song
     */
    public String getName() {
        return name;
    }

    /**
     * @return the artists of the song
     */
    public String[] getArtists() {
        return artists;
    }
}
