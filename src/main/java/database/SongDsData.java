package database;
import entities.Song;

import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Data storage class between database class and entities. In the Application Business Rules layer.
 */
public class SongDsData {
    private final Song song;

    /**
     * Constructor to be called from database to build from .csv
     * @param id integer id of the song
     * @param name string name of the song
     * @param artistList string array of artists of the song
     * @param genre string genre of the song
     * @param file File representation of the song
     * @param cover image of the album cover of the song
     * @param uploader string name of the uploader of the song
     */
    public SongDsData(int id, String name, String[] artistList, String genre,
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
     * @return The String[] representation of the Song.
     */
    public String[] getString(){
        return new String[]{Integer.toString(this.getID()), this.getSong().getName(),
                this.getSong().getArtistString(), this.getSong().getGenre()};
    }

    /**
     * @return the genre of the Song represented by this object
     */
    public String getGenre() {
        return this.song.getGenre();
    }

    /**
     * @param filepath the filepath representing the song
     */
    protected void setFile(String filepath){
        this.song.setFile(new File(filepath));
    }
}
