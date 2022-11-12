package InputData;

import Entities.Song;

public class songInputData {
    private final Song song;

    /**
     * constructor.
     * @param song object that is wrapped in the songInputData
     */
    public songInputData(Song song){
        this.song = song;
    }

    /**
     * getter for the song private attribute
     * @return the song object stored w/in the songInputData
     */
    public Song getSong(){
        return this.song;
    }
    
}
