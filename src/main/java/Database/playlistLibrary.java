package Database;

import Entities.Playlist;
import Entities.Song;
import Entities.User;

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
            new playlistLibrary("./src/main/java/Database/playlists.csv", userList.getInstance());
    Map<Integer, Playlist> playlistDatabase;
    String filepath;
    songLibrary library;
    userList users;
    List<Integer> saved;

    /**
     * Global static method to retrieve the single instance of the playlistLibrary.
     * @return the single instance of the playlist library database
     */
    public static playlistLibrary getInstance(){
        return PLAYLIST_LIBRARY;
    }

    private playlistLibrary(String path, userList users){
        this.filepath = path;
        saved = new ArrayList<>();

        // TODO: modify once songLibrary, userList implemented
        library = new songLibrary();
        this.users = users;

        playlistDatabase = loadFile();
    }

    /**
     * Method to read the .csv file from the instance variable path and return the saved playlists.
     * @return a hashmap containing all playlists saved in the .csv file keyed with String names
     */
    private Map<Integer, Playlist> loadFile() {
        Map<Integer, Playlist> p = new HashMap<>();

        try {
            Scanner in = new Scanner(new File(filepath));
            while (in.hasNextLine()){
                // assumes 5 columns, properly filled
                String line = in.nextLine();
                String[] data = line.split(",");
                p.put(Integer.parseInt(data[0]), buildPlaylist(data));
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Creating new playlist database");
            createFile(filepath);
        }

        return p;
    }

    /**
     * A helper method for loadFile(), to build individual playlists from the data from the .csv file.
     * @param data A string array with 4 strings, containing the data for
     *             a single playlist (name, song IDs, owner, public status)
     * @return the Playlist object representing the Playlist with the data submitted
     */
    private Playlist buildPlaylist(String[] data) {
        String name = data[1];
        int id = Integer.parseInt(data[0]);
        saved.add(id);

        String[] songs = data[2].split(";");
        User owner = users.getUser(data[3]);
        boolean isPublic = Boolean.parseBoolean(data[4]);
        Playlist playlist = new Playlist(id, name, owner, isPublic);

        for (String song : songs){
            if (song.length() > 0)
                playlist.addSong(library.getSong(Integer.parseInt(song)));
        }

        return playlist;
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
            FileWriter output = new FileWriter(filepath, true);
            for (int playlist : playlistDatabase.keySet()){
                if (!saved.contains(playlist)){
                    Playlist p = playlistDatabase.get(playlist);
                    String line = buildOutput(p);
                    output.write("\n" + line);
                }
            }
            output.close();
        } catch (IOException e) {
            System.out.println("Writing db failed");
        }
    }

    /**
     * Helper method for writeFile() which builds the .csv data for a single Playlist.
     * @param p the Playlist which is being written to the .csv file.
     * @return a .csv formatted line (4 columns) representing the data of the submitted Playlist
     */
    private String buildOutput(Playlist p){
        int id = p.getId();
        int isPublic = p.returnPrivacy() ? 1 : 0;
        LinkedList<Song> songs = p.getSongList();
        ArrayList<String> songIds = new ArrayList<>();
        for (Song s : songs) {
            String songID = String.valueOf(s.getID());
            songIds.add(songID);
        }
        return id + "," + p.getName() + "," + String.join(";", songIds) + "," +
                p.getOwner().getUsername() + "," + isPublic;
    }

    /**
     * @return ArrayList of all existing Playlists
     */
    @Override
    public Collection<Playlist> getPlaylists() {
        return playlistDatabase.values();
    }

    /**
     * @param id the unique identifier of the playlist to be retrieved
     * @return Playlist with matching id or null
     */
    @Override
    public Playlist getPlaylist(int id) {
        return playlistDatabase.get(id);
    }

    /**
     * Saves a new playlist to the database.
     * @param p newly created Playlist object to be saved to the database
     */
    @Override
    public void savePlaylist(Playlist p) {
        playlistDatabase.put(p.getId(), p);
        saveFile();
    }

    /**
     * A method to check whether a playlist exists by name.
     * @param id a Integer id of a Playlist to be checked.
     * @return true if and only if there exists a Playlist of the name submitted
     */
    @Override
    public boolean exists(int id) {
        return playlistDatabase.get(id) != null;
    }
}
