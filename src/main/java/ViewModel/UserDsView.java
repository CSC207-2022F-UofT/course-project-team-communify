package ViewModel;
/**
 * Interface adapters layer interface for accessing InMemoryUser data objects.
 */
public interface UserDsView {
    /**
     * @param username the username of the user
     */
    void setUsername(String username);

    /**
     * @param playlist the playlist to be added to the user
     */
    void addPlaylist(PlaylistDsView playlist);

    /**
     * @return a blank PlaylistDsView object
     */
    PlaylistDsView getNewPlaylist();
}
