package Database;

import java.util.ArrayList;

public interface SaveSongAccessInterface {

    /**
     * @param uploader New Song object to be saved to the database.
     * @param filepath Filepath to the song.
     * @return true iff save was successful.
     */
    public boolean saveSong(String uploader, String filepath);
    
     /**
     * @param id the unique id of the song to be deleted.
     * @return true iff delete was successful.
     */
    public boolean deleteSong(int id);

    public String[][] getString();
    public String[][] getString(ArrayList<Integer> ids);
    public String[][] getString(String username);
}
