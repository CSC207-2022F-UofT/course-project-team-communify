package Database;
import java.util.HashMap;
import java.util.Collection;

/**
 *  Uses the Eager Instantiation version of the Singleton design pattern.
 *  Java executes the static initializer when the class is first loaded.
 *  Private default constructor prevents creation of subsequent songLibraries.
 */
public class songLibrary implements songAccessInterface{

    private static final songLibrary SONG_LIBRARY = new songLibrary("");
    private final HashMap<Integer, songDsData> library;
    private String filepath;

    /**
     * Global static method to retrieve the single instance of songLibrary.
     * @return The instance of songlibrary.
     */
    public static songLibrary getInstance(){
        return SONG_LIBRARY;
    }

    private songLibrary(String filepath){
        this.filepath = filepath;
        library = readFile();
    }

    /**
     * Reads song.csv and returns a Hashmap of all songs.
     * @return Hashmap mapping integer ID of a song to its respective songDsData.
     */
    private HashMap<Integer, songDsData> readFile(){
        //TODO: Implementation of reading csv of songs.
        return new HashMap<>();
    }

    /**
     * @return Collection of all songs.
     */
    public Collection<songDsData> getLibrary() {
        return library.values();
    }

    /**
     * @param song Song object to be saved to the database.
     */
    public void saveSong(songDsData song) {
        //TODO: 'Write' implementation for a single song.
    }

    /**
     * @param id the unique int ID of a given song.
     * @return true iff a song with the given ID exists.
     */
    public boolean exists(int id) {
        return library.containsKey(id);
    }

    /**
     * @param id the unique int ID of a given song.
     * @return Song inside a songDsData with matching ID, or null if it does not exist.
     */
    public songDsData getSong(int id){
        return library.get(id);
    }
}
