package OutputData;

import Entities.ArtistUser;
import Entities.Song;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

/**
 * Application Business Rules layer data structure for returning a Song object.
 */
public class songOutputData {
    private final Song song;

    public songOutputData(Song song){
        this.song = song;
    }

    /**
     * @return Song object that this output data contains.
     */
    public Song getSong() {
        return this.song;
    }

    public int getId() {
        return this.song.getID();
    }

    public String getName() {
        return this.song.getName();
    }

    public List<ArtistUser> getArtistList() {
        return this.song.getArtistList();
    }

    public int getLength() {
        return this.song.getLength();
    }

    public String getGenre() {
        return this.song.getGenre();
    }

    public File getFile() {
        return this.song.getFile();
    }

    public boolean getExplicit() {
        return this.song.getExplicit();
    }

    public BufferedImage getCover() {
        return this.song.getCover();
    }

}
