package database;
import java.util.Collection;
/**
 * Application Business Rules layer interface for accessing song data.
 */
public interface GetSongAccessInterface {
    /**
     * @return Collection of all songs.
     */
    Collection<SongDsData> getLibrary();

    /**
     * @param id the unique int ID of a given song.
     * @return true iff a song with the given ID exists.
     */
    boolean exists(int id);

    /**
     *
     * @param id the unique int ID of a given song.
     * @return Song inside a songDsData with matching ID.
     */
    SongDsData getSong(int id);
}
