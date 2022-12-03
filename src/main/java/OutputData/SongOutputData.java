package OutputData;

import Entities.Song;

import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Application Business Rules layer data structure for returning a Song object.
 */
public class SongOutputData {
    private final Song song;

    /**
     * @param song the Song to be outputted to the view
     */
    public SongOutputData(Song song){
        this.song = song;
    }

    /**
     * @return Song object that this output data contains.
     */
    public Song getSong() {
        return this.song;
    }

    /**
     * @return ID of the song object
     */
    public int getId() {
        return this.song.getID();
    }

    /**
     * @return name of the song object
     */
    public String getName() {
        return this.song.getName();
    }

    /**
     * @return artist list of the song object
     */
    public String[] getArtistList() {
        return this.song.getArtistList();
    }

    /**
     * @return genre of the song object
     */
    public String getGenre() {
        return this.song.getGenre();
    }

    /**
     * @return file representation of the song object
     */
    public File getFile() {
        return this.song.getFile();
    }

    /**
     * @return album cover of the song object
     */
    public BufferedImage getCover() {
        return this.song.getCover();
    }

}
