package InputData;

import Entities.Song;

public class songInputData {
    private final Song song;

    public songInputData(Song song){
        this.song = song;
    }

    public Song getSong() {
        return song;
    }
}
