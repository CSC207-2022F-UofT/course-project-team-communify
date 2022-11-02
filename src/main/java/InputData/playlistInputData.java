package InputData;

import Entities.Song;

import java.util.ArrayList;

/**
 * Application Business Rules layer data structure for submitting playlist input to use cases.
 */
public class playlistInputData {
    private final ArrayList<Song> songs;
    private final String name;

    public playlistInputData(ArrayList<Song> songs, String name){
        this.name = name;
        this.songs = songs;
    }

    /**
     * @return list of Song objects in this input data
     */
    public ArrayList<Song> getSongs() {
        return songs;
    }

    /**
     * @return name of the playlist in this input data
     */
    public String getName() {
        return name;
    }
}
