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
    private final String name;
    private final LinkedList<Song> songList;

    public playlistInputData(String name, LinkedList<Song> songList){
        this.name = name;
        this.songList = songList;
    }

    public playlistInputData(int id){
        playlistAccessInterface library = playlistLibrary.getInstance();
        this.name = library.findPlaylist(id).getPlaylist().getName();
        this.songList = new LinkedList<>(library.findPlaylist(id).getPlaylist().getSongList());
    }

    /**
     * @return list of Song objects in this input data
     */
    public ArrayList<Song> getSongs() {
        return new ArrayList<>(this.songList);
    }

    /**
     * @return name of the playlist in this input data
     */
    public String getName() {
        return name;
    }
}
