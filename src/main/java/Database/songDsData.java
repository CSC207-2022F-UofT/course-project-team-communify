package Database;

import Entities.Song;

/**
 * Data storage class between database class and entities.
 */
public class songDsData {
    private final Song song;

    public songDsData(int id) {
        // TODO: remove once class is complete
        this.song = new Song(id, null, null, 0, null, null, false, null);
    }

    public songDsData(Song song){
        this.song = song;
    }

    public songDsData(String[] data){
        //TODO: Implementation for use when reading in from csv.
        // temporary constructor to avoid null exception in other tests
        this.song = new Song(0, null, null, 0, null, null,
                false, null);
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
