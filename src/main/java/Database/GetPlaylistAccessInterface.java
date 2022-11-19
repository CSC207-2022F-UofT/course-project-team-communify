package Database;

/**
 * Application Business Rules layer interface for accessing playlist data.
 */
public interface GetPlaylistAccessInterface {
    /**
     * Finds a playlist by unique identifier
     * @param id the unique identifier of the playlist to be retrieved
     * @return Playlist with matching id or null
     */
    playlistDsData findPlaylist(int id);
}
