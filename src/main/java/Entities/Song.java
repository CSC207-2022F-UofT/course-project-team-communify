package Entities;
import java.awt.image.BufferedImage;
import java.util.List;

public class Song {

    private final int id;
    private final String name;
    private final List artistList;
    private final int length;
    private final String genre;
    private final String fileLocation;
    private final boolean isExplicit;
    private final BufferedImage cover;


    public Song(int id, String name, List artistList, int length, String genre,
                String fileLocation, boolean isExplicit, BufferedImage cover){
        this.id = id;
        this.name = name;
        this.artistList = artistList;
        this.length = length;
        this.genre = genre;
        this.fileLocation = fileLocation;
        this.isExplicit = isExplicit;
        this.cover = cover;
    }

    public int getID(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public List getArtistList(){
        return this.artistList;
    }

    public int getLength(){
        return this.length;
    }

    public String getGenre(){
        return this.genre;
    }

    public String getFileLocation(){
        return this.fileLocation;
    }

    public boolean getExplicit(){
        return this.isExplicit;
    }

    public BufferedImage getCover(){
        return this.cover;
    }
}
