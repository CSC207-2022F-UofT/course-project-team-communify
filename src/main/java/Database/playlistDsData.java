package Database;

import Entities.Playlist;
import Entities.Song;
import Entities.User;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * A data storage class in the Application Business Rules layer abstracting the interaction between database
 * classes and entities.
 */
public class playlistDsData {
    private final Playlist playlist;
    private final songAccessInterface library;
    private final userAccessInterface users;
    
    public playlistDsData(Playlist p){
        // constructor for creation from use case to pass to database
        this.playlist = p;
        library = songLibrary.getInstance();
        users = userList.getInstance();
    }
    
    public playlistDsData(String[] data){
        library = songLibrary.getInstance();
        users = userList.getInstance();
        this.playlist = buildPlaylist(data);
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

        String[] songs = data[2].split(";");
        User owner = users.getUser(data[3]).getUser();
        boolean isPublic = Boolean.parseBoolean(data[4]);
        Playlist playlist = new Playlist(id, name, owner, isPublic);

        for (String song : songs){
            if (song.length() > 0)
                playlist.addSong(library.getSong(Integer.parseInt(song)).getSong());
        }

        return playlist;
    }

    /**
     * Helper method for writeFile() in the playlistLibrary which builds the .csv data for a single Playlist.
     * @return a .csv formatted line (4 columns) representing the data of the submitted Playlist
     */
    public String buildOutput() {
        int id = playlist.getId();
        int isPublic = playlist.returnPrivacy() ? 1 : 0;
        LinkedList<Song> songs = playlist.getSongList();
        ArrayList<String> songIds = new ArrayList<>();
        for (Song s : songs) {
            String songID = String.valueOf(s.getID());
            songIds.add(songID);
        }
        return id + "," + playlist.getName() + "," + String.join(";", songIds) + "," +
                playlist.getOwner().getUsername() + "," + isPublic;
    }

    /**
     * @return the id of the Playlist stored
     */
    public int getId() {
        return playlist.getId();
    }

    /**
     * @return the Playlist entity stored
     */
    public Playlist getPlaylist() {
        return playlist;
    }
}
