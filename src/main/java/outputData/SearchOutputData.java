package outputData;


import entities.Song;

import java.util.List;

/**
 * Application Business Rules layer data structure for receiving search output from use cases.
 */
public class SearchOutputData {
    private final List<Song> foundSongs;

    /**
     * @param foundSongs the list of songs found by the search
     */
    public SearchOutputData(List<Song> foundSongs){
        this.foundSongs = foundSongs;
    }

    /**
     * @return the search results
     */
    public List<Song> getFoundSongs() {
        return foundSongs;
    }
}
