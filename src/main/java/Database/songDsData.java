package Database;

import Entities.Song;

/**
 * Data storage class between database class and entities.
 */
public class songDsData {
    private Song song;

    public songDsData(Song song){
        this.song = song;
    }

    public songDsData(String[] data){
        //TODO: Implementation for use when reading in from csv.
    }

    public Song buildFromWrite(){
        //TODO: Helper for String[] data constructor.
        return null;
    }

    public String buildToWrite(){
        //TODO: Helper to turn into csv formatted line.
        return null;
    }

    public Song getSong() {
        return this.song;
    }
}
