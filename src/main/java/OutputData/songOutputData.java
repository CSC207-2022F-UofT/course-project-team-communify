package OutputData;

import Entities.Song;

public class songOutputData {
    private final Song song;

    public songOutputData(Song song){
        this.song = song;
    }

    public Song getSong() {
        return song;
    }
}
