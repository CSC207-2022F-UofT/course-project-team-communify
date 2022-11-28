package ViewModel;
/**
 * Interface adapters layer interface for accessing InMemoryPlaylist data objects.
 */
public interface PlaylistDsView {
    /**
     * @param id the ID of the playlist
     */
    void setId(int id);

    /**
     * @param name the name of the playlist
     */
    void setName(String name);

    /**
     * @param s the song to add to the playlist
     */
    void addSong(SongDsView s);

    /**
     * @param s the song to remove
     */
    void removeSong(SongDsView s);

    /**
     * @return an empty SongDsView object
     */
    SongDsView getNewSong();

    /**
     * @return the ID of the playlist
     */
    int getId();
}
