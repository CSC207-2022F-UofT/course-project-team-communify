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

    /**
     *
     * @param id Unique identifier of the song.
     * @param name Name of the song.
     * @param artistList List of contributing artists.
     * @param genre Type of song.
     * @param file Audio file itself.
     * @param cover Cover image of the song.
     * @param uploader Username of user who uploaded the song.
     */
    public Song(int id, String name, String[] artistList, String genre,
                File file, BufferedImage cover, String uploader){

        this.id = id;
        this.name = name;
        this.artistList = artistList;
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

    /**
     * @return The uploader of the song.
     */
    public String getUploader(){
        return this.uploader;
    }

    /**
     * @return String representation of all artists.
     */
    public String getArtistString(){
        //TODO: Replace this terrible lazy implementation
        StringBuilder artists = new StringBuilder();
        for(int i=0;i<artistList.length;i++){
            artists.append(artistList[i]);
            if(i+1<artistList.length) artists.append(", ");
        }
        return artists.toString();
    }

}
