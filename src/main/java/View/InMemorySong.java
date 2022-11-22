package View;

import ViewModel.SongDsView;

import java.awt.image.BufferedImage;

public class InMemorySong implements SongDsView {
    private String name;
    private BufferedImage cover;
    private String[] artists;
    private String genre;
    private int id;

    public InMemorySong(){

    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setCover(BufferedImage cover) {
        this.cover = cover;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public void setArtists(String[] artists) {
        this.artists = artists;
    }

    public int getId() {
        return id;
    }

    public BufferedImage getCover() {
        return cover;
    }

    public String getGenre() {
        return genre;
    }

    public String getName() {
        return name;
    }

    public String[] getArtists() {
        return artists;
    }
}
