package InputData;

import Database.GetPlaylistAccessInterface;
import Database.playlistLibrary;
import Entities.Song;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Application Business Rules layer data structure for submitting playlist input to use cases.
 */
public class playlistInputData {
    private final String name;
    private final LinkedList<Song> songList;
    private final List<songInputData> songInputList;
    private final int id;

    /**
     * @param name String name of the playlist
     * @param songList list of Songs in the playlist
     */
    public playlistInputData(String name, List<Song> songList){
        this.name = name;
        this.songList = new LinkedList<>(songList);
        this.id = -1;
        this.songInputList = new ArrayList<>();

        for (Song s : songList)
            songInputList.add(new songInputData(s));
    }

    /**
     * Overloaded constructor to find a playlist in the database by ID
     * @param id int ID of the Playlist
     */
    public playlistInputData(int id){
        GetPlaylistAccessInterface library = playlistLibrary.getInstance();
        this.name = library.findPlaylist(id).getPlaylist().getName();
        this.songList = new LinkedList<>(library.findPlaylist(id).getPlaylist().getSongList());
        this.id = id;
        this.songInputList = new ArrayList<>();

        for (Song s : songList)
            songInputList.add(new songInputData(s));
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

    /**
     * @return the ID of the playlist if created via ID, -1 otherwise
     */
    public int getId() {
        return id;
    }

    /**
     * @return list of songs in the playlist formatted as songInputData objects
     */
    public List<songInputData> getSongInputList() {
        return songInputList;
    }
}
