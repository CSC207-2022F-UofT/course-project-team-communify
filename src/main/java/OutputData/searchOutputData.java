package OutputData;


import Entities.Song;

import java.util.List;

public class searchOutputData {
    private List<Song> foundSongs;

    public searchOutputData(List<Song> foundSongs){
        this.foundSongs = foundSongs;
    }

    public List<Song> getFoundSongs() {
        return foundSongs;
    }
}
