package InputData;

import Entities.Song;

import java.util.ArrayList;

public class playlistInputData {
    private final ArrayList<Song> songs;
    private final String name;

    public playlistInputData(ArrayList<Song> songs, String name){
        this.name = name;
        this.songs = songs;
    }
    public ArrayList<Song> getSongs() {
        return songs;
    }

    public String getName() {
        return name;
    }
}
