package ViewModel;

public interface UserDsView {
    void setUsername(String username);

    void addPlaylist(PlaylistDsView playlist);

    PlaylistDsView getNewPlaylist();
}
