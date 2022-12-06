package database;

import java.util.ArrayList;
/**
 * Application Business Rules layer interface for saving song data.
 */
public interface SaveSongAccessInterface {

    /**
     * @param uploader New Song object to be saved to the database.
     * @param filepath Filepath to the song.
     * @return true iff save was successful.
     */
    boolean saveSong(String uploader, String filepath);

    /**
     * used for testing
     * @return a 2d String array representation of the library
     */
    String[][] getString();

    /**
     * used for testing
     * @param ids the IDs of songs to get a string for
     * @return a 2d String array representation of the provided song IDs
     */
    String[][] getString(ArrayList<Integer> ids);

    /**
     * @param username username of the Artist to query
     * @return 2D array representation of all songs owned by an artist
     */
    String[][] getString(String username);
}
