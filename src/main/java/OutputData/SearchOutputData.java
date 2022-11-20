package OutputData;


import Entities.Song;

import java.util.List;

public class SearchOutputData {
    List<Song> foundSongs;

    public SearchOutputData(List<Song> foundSongs){
        this.foundSongs = foundSongs;
    }
}
