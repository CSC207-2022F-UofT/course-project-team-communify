package database;

/**
 * Application Business Rules layer interface for accessing user data.
 */
public interface SavePlaylistAccessInterface {
    /**
     * Saves a new playlist to the database.
     * @param p newly created Playlist object to be saved to the database
     */
    void savePlaylist(PlaylistDsData p);

    /**
     * A method to check whether a playlist exists by id. Necessary when creating new playlists,
     * must generate a new id and make sure that it is not already in use.
     * @param id the integer id of the playlist object.
     * @return true if and only if there exists a Playlist of the name submitted
     */
    boolean exists(int id);
}
