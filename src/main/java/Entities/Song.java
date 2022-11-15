package Entities;

import java.awt.image.BufferedImage;
import java.io.File;

public class Song {

    private final int id;
    private final String name;
    private final String[] artistList;
    private final String genre;
    private final File file;
    private final BufferedImage cover;
    private final String uploader;
    private final int length;

    /**
     * @param id         Unique identifier of the song.
     * @param name       Name of the song.
     * @param artistList List of contributing artists.
     * @param genre      Type of song.
     * @param file       Audio file itself.
     * @param cover      Cover image of the song.
     * @param uploader   Username of user who uploaded the song.
     */
    public Song(int id, String name, String[] artistList, int length, String genre,
                File file, BufferedImage cover, String uploader){
        this.id = id;
        this.name = name;
        this.artistList = artistList;
        this.length = length;
        this.genre = genre;
        this.file = file;
        this.cover = cover;
        this.uploader = uploader;
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
     * @return list of contributing artists.
     */
    public String[] getArtistList(){
        return this.artistList;
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
     * @return BufferedImage of song cover.
     */
    public BufferedImage getCover(){
        return this.cover;
    }

    public String getUploader(){
        return this.uploader;
    }
}
