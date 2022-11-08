package InputData;

import Entities.Space;
import Entities.Song;

/**
 * class containing all data required to play or add a song to the space.
 */
public class spaceInputData {
    private final Space space;
    private final Song song;

    /**
     * constructor.
     * @param space space that song pertains to
     * @param song song to be played or added
     */
    public spaceInputData(Space space, Song song){
        this.space = space;
        this.song = song;
    }

    /**
     * @return Space object, getter for space instance variable
     */
    public Space getSpace(){
        return this.space;
    }

    /**
     * @return Song object, getter for song instance variable
     */
    public Song getSong(){
        return this.song;
    }
}
