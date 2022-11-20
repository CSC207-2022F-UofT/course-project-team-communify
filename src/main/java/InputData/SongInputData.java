package InputData;

import Database.GetSongAccessInterface;
import Database.SongLibrary;
import Entities.Song;

import java.awt.image.BufferedImage;
import java.io.File;

public class SongInputData {
    private final Song song;

    public SongInputData(Song song){
        this.song = song;
    }

    public SongInputData(int id){
        GetSongAccessInterface library = SongLibrary.getInstance();
        this.song = library.getSong(id).getSong();
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

    public String[] getArtistList() {
        return this.song.getArtistList();
    }


    public String getGenre() {
        return this.song.getGenre();
    }

    public File getFile() {
        return this.song.getFile();
    }

    public BufferedImage getCover() {
        return this.song.getCover();
    }
}






