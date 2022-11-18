package Database;
import java.util.Collection;

public interface GetSongAccessInterface {
    /**
     * @return Collection of all songs.
     */
    public Collection<songDsData> getLibrary();

    /**
     * @param id the unique int ID of a given song.
     * @return true iff a song with the given ID exists.
     */
    public boolean exists(int id);

    /**
     *
     * @param id the unique int ID of a given song.
     * @return Song inside a songDsData with matching ID.
     */
    public songDsData getSong(int id);
}
