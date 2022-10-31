package Entities;

import java.util.ArrayList;

public class Space {
    private final ArrayList<Song> songList;

    public Space(ArrayList<Song> songList) {
        this.songList = songList;
    }

    public ArrayList<Song> getSongList() {
        return songList;
    }

    public void addSongToSongList(Song song){
        this.songList.add(song);
    }
}
