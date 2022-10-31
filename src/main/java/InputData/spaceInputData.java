package InputData;

import Entities.Space;
import Entities.Song;

public class spaceInputData {
    private final Space space;
    private final Song song;

    public spaceInputData(Space space, Song song){
        this.space = space;
        this.song = song;
    }

    public Space getSpace(){
        return this.space;
    }

    public Song getSong(){
        return this.song;
    }
}
