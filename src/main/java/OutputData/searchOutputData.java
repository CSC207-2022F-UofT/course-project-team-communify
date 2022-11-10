package OutputData;


import Entities.Song;

import java.util.List;

public class searchOutputData {
    List<Song> foundSongs;

    public searchOutputData(List<Song> foundSongs ){
        this.foundSongs = foundSongs;
    }
}
