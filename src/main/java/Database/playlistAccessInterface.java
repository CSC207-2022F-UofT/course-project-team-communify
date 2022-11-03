package Database;

import java.util.Collection;

public interface playlistAccessInterface {

    /**
     * @return ArrayList of all existing Playlists
     */
    public Collection<playlistDsData> getPlaylists();

    /**
     * Saves a new playlist to the database.
     * @param p newly created Playlist object to be saved to the database
     */
    public void savePlaylist(playlistDsData p);

    /**
     * Finds a playlist by unique identifier
     * @param id the unique identifier of the playlist to be retrieved
     * @return Playlist with matching id or null
     */
    public playlistDsData findPlaylist(int id);

    /**
     * A method to check whether a playlist exists by id. Necessary when creating new playlists,
     * must generate a new id and make sure that it is not already in use.
     * @param id the integer id of the playlist object.
     * @return true if and only if there exists a Playlist of the name submitted
     */
    public boolean exists(int id);
}
