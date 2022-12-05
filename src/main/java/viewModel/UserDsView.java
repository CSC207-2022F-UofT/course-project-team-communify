package viewModel;
/**
 * Interface adapters layer interface for accessing InMemoryUser data objects.
 */
public interface UserDsView {
    /**
     * @param username the username of the user
     */
    void setUsername(String username);

    /**
     * @return the username of the current user
     */
    String getUsername();

    /**
     * @param playlist the playlist to be added to the user
     * @param first if the playlist should be added first
     */
    void addPlaylist(PlaylistDsView playlist, boolean first);

    /**
     * @return a blank PlaylistDsView object
     */
    PlaylistDsView getNewPlaylist();
}
