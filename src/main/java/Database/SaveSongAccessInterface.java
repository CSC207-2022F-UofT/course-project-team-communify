package Database;

import java.util.ArrayList;

public interface SaveSongAccessInterface {

    /**
     * @param uploader New Song object to be saved to the database.
     * @param filepath Filepath to the song.
     * @return true iff save was successful.
     */
    boolean saveSong(String uploader, String filepath);
    
     /**
     * @param id the unique id of the song to be deleted.
     * @return true iff delete was successful.
     */
     boolean deleteSong(int id);

    /**
     * @return a 2d String array representation of the library
     */
    String[][] getString();

    /**
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
