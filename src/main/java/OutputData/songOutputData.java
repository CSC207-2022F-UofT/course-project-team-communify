package OutputData;

import Entities.Song;

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
        return song;
    }
}
