package Database;

public interface SaveSongAccessInterface {

    /**
     * @param uploader New Song object to be saved to the database.
     * @param filepath Filepath to the song.
     * @return true iff save was successful.
     */
    public boolean saveSong(String uploader, String filepath);

}
