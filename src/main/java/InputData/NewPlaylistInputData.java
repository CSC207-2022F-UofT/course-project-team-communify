package InputData;
import Database.*;
import Entities.RegularUser;
import Entities.Song;

import java.util.Random;

/**
 * Application Business Rules layer data structure for submitting new playlist input to use cases.
 */
public class NewPlaylistInputData {
    private final int id;
    private final String playlistName;
    private final RegularUser owner;
    //Based off of Assumption that only RegularUser objects can generate playlists
    private final Song firstSong;

    /**data for creating an empty playlist
     * @param playlistName name of the playlist
     * @param owner username of the owner
     *
     *
     */
    public NewPlaylistInputData(String playlistName, String owner){
        this.id = getNewID();
        this.playlistName = playlistName;
        this.owner = getUser(owner);
        this.firstSong = null;
    }

    /**data for creating a playlist with one object
     * @param playlistName name of the playlist
     * @param firstSongID generate this playlist with a singular song of this ID
     * @param owner username of the owner
     *
     *
     */
    public NewPlaylistInputData(String playlistName, int firstSongID, String owner){
        this.id = getNewID();
        this.playlistName = playlistName;
        this.owner = getUser(owner);
        GetSongAccessInterface sLib = SongLibrary.getInstance();
        this.firstSong = sLib.getSong(firstSongID).getSong();
    }

    /**
     * @return name of the playlist
     */
    public String getPlaylistName(){
        return this.playlistName;
    }

    /**
     * @return owner of the playlist
     */
    public RegularUser getOwner(){
        return this.owner;
    }

    /**
     * @return whether the playlist has a first song
     */
    public boolean hasFirstSong(){
        return this.firstSong != null;
    }

    /**
     * @return the first song of the playlist
     */
    public Song getFirstSong(){
        return this.firstSong;
    }

    /**
     * @return the ID of the playlist
     */
    public int getId() {
        return this.id;
    }

    /**
     * @param username the username of the user
     * @return the user object representing this user
     */
    private RegularUser getUser(String username){
        GetUserAccessInterface users = UserList.getInstance();
        return (RegularUser) users.getUser(username).getUser();
    }

    /**
     * @return a new unused playlist ID
     */
    private int getNewID(){
        GetPlaylistAccessInterface library = PlaylistLibrary.getInstance();
        Random random = new Random();
        int temp = Math.abs(random.nextInt(10000));
        while (library.findPlaylist(temp) != null){
            temp = Math.abs(random.nextInt(10000));
        }
        return temp;
    }
}
