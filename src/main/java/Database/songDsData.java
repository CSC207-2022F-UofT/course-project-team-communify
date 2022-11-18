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

    /**
     * Helper method for saving the database to a file.
     * @return String representation of a Song to be written to a .csv
     */
    public String buildToWrite(){
        return this.song.getID() + "," + this.song.getUploader() + "," + this.song.getFile().getPath() + "\n";
    }

    /**
     * @return the Song represented by this object
     */
    public Song getSong() {
        return this.song;
    }

    /**
     * @return the ID of the Song represented by this object
     */
    public int getID(){
        return this.song.getID();
    }

    /**
     * @return the genre of the Song represented by this object
     */
    public String getGenre() {
        return this.song.getGenre();
    }
}
