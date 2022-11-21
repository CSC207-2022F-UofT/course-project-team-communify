package ViewModel;

public interface PlaylistDsView {
    void setId(int id);

    void setName(String name);

    void addSong(SongDsView s);

    SongDsView getNewSong();
}
