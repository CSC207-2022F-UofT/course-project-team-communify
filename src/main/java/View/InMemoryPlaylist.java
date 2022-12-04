package view;

import viewModel.PlaylistDsView;
import viewModel.SongDsView;

import java.util.ArrayList;
/**
 * A view layer data structure to store the playlist in memory.
 */
public class InMemoryPlaylist implements PlaylistDsView {
    private String name;
    private int id;
    private final ArrayList<InMemorySong> songs;

    /**
     * Constructor
     */
    public InMemoryPlaylist(){
        songs = new ArrayList<>();
    }

    /**
     * @return the songs in the playlist
     */
    public ArrayList<InMemorySong> getSongs() {
        return songs;
    }

    /**
     * @return the name of the playlist
     */
    public String getName() {
        return name;
    }

    /**
     * @return the ID of the playlist
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * @param id the ID of the playlist
     */
    @Override
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param name the name of the playlist
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param s the song to add to the playlist
     */
    @Override
    public void addSong(SongDsView s){
        songs.add((InMemorySong) s);
    }

    /**
     * @param s the song to remove
     */
    @Override
    public void removeSong(SongDsView s){
        songs.remove((InMemorySong) s);
    }

    /**
     * @return a blank song
     */
    @Override
    public SongDsView getNewSong(){
        return new InMemorySong();
    }


}
