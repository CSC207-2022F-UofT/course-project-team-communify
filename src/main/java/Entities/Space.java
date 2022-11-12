package Entities;

import java.util.ArrayList;

/**
 * Space entity. Similar to a radio.
 */
public class Space {
    private final ArrayList<Song> songList;

    /**
     * Constructor.
     * @param songList songs to be played
     */
    public Space(ArrayList<Song> songList) {
        this.songList = songList;
    }

    /**
     * songList getter
     * @return space's songList attribute
     */
    public ArrayList<Song> getSongList() {
        return songList;
    }

    /**
     * @param song song to add to songList (add to queue)
     */
    public void addSongToSongList(Song song){
        this.songList.add(song);
    }
}
