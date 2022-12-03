package InputData;

import Database.GetSongAccessInterface;
import Database.SongLibrary;
import Entities.Song;

import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Application Business Rules layer data structure for submitting song input to use cases.
 */
public class SongInputData {
    private final Song song;

    /**
     * @param song the Song object to encapsulate
     */
    public SongInputData(Song song){
        this.song = song;
    }

    /**
     * Overloaded constructor to find a song in the database by ID.
     * @param id ID of the Song object to encapsulate
     */
    public SongInputData(int id){
        GetSongAccessInterface library = SongLibrary.getInstance();
        this.song = library.getSong(id).getSong();
    }

    /**
     * @return the song object stored
     */
    public Song getSong() {
        return song;
    }

    /**
     * @return the ID of the song object stored
     */
    public int getId() {
        return this.song.getID();
    }

    /**
     * @return the name of the song object stored
     */
    public String getName() {
        return this.song.getName();
    }

    /**
     * @return the artist list of the song object stored
     */
    public String[] getArtistList() {
        return this.song.getArtistList();
    }

    /**
     * @return the genre of the song object stored
     */
    public String getGenre() {
        return this.song.getGenre();
    }

    /**
     * @return the File representation of the song object stored
     */
    public File getFile() {
        return this.song.getFile();
    }

    /**
     * @return the album cover of the song object stored
     */
    public BufferedImage getCover() {
        return this.song.getCover();
    }
}






