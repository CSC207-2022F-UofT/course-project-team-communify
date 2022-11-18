package Database;
import Entities.Song;

import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Data storage class between database class and entities.
 */
public class songDsData {
    private final Song song;

    public songDsData(Song song){
        this.song = song;
    }

    public songDsData(int id, String name, String[] artistList, String genre,
                      File file, BufferedImage cover, String uploader){
       this.song = new Song(id, name, artistList, genre, file, cover, uploader);
    }

    public String buildToWrite(){
        return this.song.getID() + "," + this.song.getUploader() + "," + this.song.getFile().getPath() + "\n";
    }

    public Song getSong() {
        return this.song;
    }

    public int getID(){
        return this.song.getID();
    }

    public String getGenre() {
        return this.song.getGenre();
    }
}
