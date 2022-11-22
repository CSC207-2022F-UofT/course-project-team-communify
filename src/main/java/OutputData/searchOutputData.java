package OutputData;


import Entities.Song;

import java.util.List;

/**
 * Application Business Rules layer data structure for receiving search output from use cases.
 */
public class searchOutputData {
    private List<Song> foundSongs;

    /**
     * @param foundSongs the list of songs found by the search
     */
    public searchOutputData(List<Song> foundSongs){
        this.foundSongs = foundSongs;
    }

    public List<Song> getFoundSongs() {
        return foundSongs;
    }
}
