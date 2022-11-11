package Database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Playlist database class in the Frameworks & Drivers layer that follows the singleton design pattern, and
 * implements an interface in the Application Business Rules layer for dependency inversion purposes.
 * Note: since this is a singleton class, the constructor is private, and it can NOT be created with the
 * new keyword outside this class.
 */
public class playlistLibrary implements playlistAccessInterface {
    private static final playlistLibrary PLAYLIST_LIBRARY =
            new playlistLibrary("./src/main/java/Database/playlists.csv");
    private final Map<Integer, playlistDsData> playlistDatabase;
    private final String filepath;


    /**
     * Global static method to retrieve the single instance of the playlistLibrary.
     * @return the single instance of the playlist library database
     */
    public static playlistLibrary getInstance(){
        return PLAYLIST_LIBRARY;
    }

    private playlistLibrary(String path){
        this.filepath = path;
        playlistDatabase = loadFile();
    }

    /**
     * Method to read the .csv file from the instance variable path and return the saved playlists.
     * @return a hashmap containing all playlists saved in the .csv file keyed with String names
     */
    private Map<Integer, playlistDsData> loadFile() {
        Map<Integer, playlistDsData> p = new HashMap<>();

        try {
            Scanner in = new Scanner(new File(filepath));
            while (in.hasNextLine()){
                // assumes 5 columns, properly filled
                String line = in.nextLine();
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                p.put(Integer.parseInt(data[0]), new playlistDsData(data));
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Creating new playlist database");
            createFile(filepath);
        }

        return p;
    }

    /**
     * A helper method for loadFile() which creates a blank .csv database if the file is not found.
     * @param fp The filepath of the .csv database.
     */
    private void createFile(String fp){
        File db = new File(fp);
        try {
            System.out.println(db.createNewFile());
        } catch (IOException ex) {
            System.out.println("Failed db creation");
        }
    }

    /**
     * Method called by savePlaylist() which writes any newly created playlists to the .csv file.
     */
    private void saveFile(){
        try {
            FileWriter output = new FileWriter(filepath, false);
            for (int playlist : playlistDatabase.keySet()){
                playlistDsData p = playlistDatabase.get(playlist);
                String line = p.buildOutput();
                output.write("\n" + line);
            }
            output.close();
        } catch (IOException e) {
            System.out.println("Writing db failed");
        }
    }

    /**
     * @return Collection of all existing Playlists
     */
    @Override
    public Collection<playlistDsData> getPlaylists() {
        return playlistDatabase.values();
    }

    /**
     * @param id the unique identifier of the playlist to be retrieved
     * @return Playlist with matching id or null
     */
    @Override
    public playlistDsData findPlaylist(int id) {
        return playlistDatabase.get(id);
    }

    /**
     * Saves a new playlist to the database.
     * @param p newly created Playlist object to be saved to the database
     */
    @Override
    public void savePlaylist(playlistDsData p) {
        playlistDatabase.put(p.getId(), p);
        saveFile();
    }

    /**
     * A method to check whether a playlist exists by name.
     * @param id an Integer id of a Playlist to be checked.
     * @return true if and only if there exists a Playlist of the name submitted
     */
    @Override
    public boolean exists(int id) {
        return playlistDatabase.get(id) != null;
    }
}
