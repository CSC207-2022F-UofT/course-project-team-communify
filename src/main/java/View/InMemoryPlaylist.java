package View;

import ViewModel.PlaylistDsView;
import ViewModel.SongDsView;

import java.util.ArrayList;

public class InMemoryPlaylist implements PlaylistDsView {
    private String name;
    private int id;
    private final ArrayList<InMemorySong> songs;

    public InMemoryPlaylist(){
        songs = new ArrayList<>();
    }

    public ArrayList<InMemorySong> getSongs() {
        return songs;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void addSong(SongDsView s){
        songs.add((InMemorySong) s);
    }

    @Override
    public SongDsView getNewSong(){
        return new InMemorySong();
    }


}
