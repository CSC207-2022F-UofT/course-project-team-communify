package Entities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

public class Song {

    private final int id;
    private final String name;
    private final List<ArtistUser> artistList;
    private final int length;
    private final String genre;
    private final File file;
    private final BufferedImage cover;
    private final String uploader;

    /**
     * @param id         Unique identifier of the song.
     * @param name       Name of the song.
     * @param artistList List of contributing artists.
     * @param length
     * @param genre      Type of song.
     * @param file       Audio file itself.
     * @param cover      Cover image of the song.
     * @param uploader   Username of user who uploaded the song.
     */
    public Song(int id, String name, List<ArtistUser> artistList, int length, String genre,
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
     *
     * @return list of contributing artists.
     */
    public List<ArtistUser> getArtistList(){
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
