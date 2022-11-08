package Entities;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

public class Song {

    private final int id;
    private final String name;
    private final List artistList;
    private final int length;
    private final String genre;
    private final File file;
    private final boolean isExplicit;
    private final BufferedImage cover;

    /**
     *
     * @param id Unique identifier of the song.
     * @param name Name of the song.
     * @param artistList List of contributing artists.
     * @param length Length of the song, in seconds.
     * @param genre Type of song.
     * @param file Audio file itself.
     * @param isExplicit Whether the song is explicit or not.
     * @param cover Cover image of the song.
     */
    public Song(int id, String name, List artistList, int length, String genre,
                File file, boolean isExplicit, BufferedImage cover){
        this.id = id;
        this.name = name;
        this.artistList = artistList;
        this.length = length;
        this.genre = genre;
        this.file = file;
        this.isExplicit = isExplicit;
        this.cover = cover;
    }

    /**
     * @return unique ID of Song.
     */
    public int getID(){
        return this.id;
    }

    /**
     * @return name of Song.
     */
    public String getName(){
        return this.name;
    }

    /**
     *
     * @return list of contributing artists.
     */
    public List getArtistList(){
        return this.artistList;
    }

    /**
     * @return int length of song, in seconds.
     */
    public int getLength(){
        return this.length;
    }

    /**
     * @return genre of song.
     */
    public String getGenre(){
        return this.genre;
    }

    /**
     * @return File object representing the song.
     */
    public File getFile(){
        return this.file;
    }

    /**
     * @return true if the song is explicit.
     */
    public boolean getExplicit(){
        return this.isExplicit;
    }

    /**
     * @return BufferedImage of song cover.
     */
    public BufferedImage getCover(){
        return this.cover;
    }
}
