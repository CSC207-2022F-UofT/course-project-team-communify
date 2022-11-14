package InputData;

import Database.playlistAccessInterface;
import Database.playlistLibrary;
import Entities.Song;

import java.util.ArrayList;
import java.util.LinkedList;

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

    public playlistInputData(int id){
        playlistAccessInterface library = playlistLibrary.getInstance();
        this.name = library.findPlaylist(id).getPlaylist().getName();
        this.songs = new ArrayList<>(library.findPlaylist(id).getPlaylist().getSongList());
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
