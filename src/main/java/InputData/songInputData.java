package InputData;

import Entities.Song;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

public class songInputData {
    private final Song song;

    public songInputData(Song song){
        this.song = song;
    }

    public Song getSong() {
        return song;
    }

    public int getId() {
        return this.song.getID();
    }

    public String getName() {
        return this.song.getName();
    }

    public List<String> getArtistList() {
        return this.song.getArtistList();
    }

    public int getLength() {
        return this.song.getLength();
    }

    public String getGenre() {
        return this.song.getGenre();
    }

    public File getFile() {
        return this.song.getFile();
    }

    public boolean getExplicit() {
        return this.song.getExplicit();
    }

    public BufferedImage getCover() {
        return this.song.getCover();
    }
}






