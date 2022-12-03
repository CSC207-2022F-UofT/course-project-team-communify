package InputData;
import Database.*;
import Entities.Playlist;
import Entities.RegularUser;
import Entities.Song;
import Entities.User;

/**
 * Application Business Rules layer data structure for submitting playlist input to use cases.
 */
public class EditPlaylistInputData {
    private final Playlist playlist;
    private final Song song;
    private final RegularUser user;

    /**
     * @param user User which owns the playlist
     * @param playlist Playlist to be edited
     * @param song Song to be added/removed from the Playlist
     */
    public EditPlaylistInputData(String user, int playlist, int song){
        GetPlaylistAccessInterface pLib = PlaylistLibrary.getInstance();
        GetSongAccessInterface sLib = SongLibrary.getInstance();
        this.playlist = pLib.findPlaylist(playlist).getPlaylist();
        this.song = sLib.getSong(song).getSong();
        this.user = getUser(user);
    }

    /**
     * @return the ID of the song to be added/removed.
     */
    public int getSongID(){
        return this.song.getID();
    }

    /**
     * @return the User owner of the playlist
     */
    public User getUser(){
        return this.user;
    }

    /**
     * @return the playlist to be edited
     */
    public Playlist getPlaylist(){
        return this.playlist;
    }

    /**
     * @return the Song to be added/removed from the playlist
     */
    public Song getSong(){
        return this.song;
    }
    /**
     * @param username the username of the user
     * @return the user object representing this user
     */
    private RegularUser getUser(String username){
        GetUserAccessInterface users = UserList.getInstance();
        return (RegularUser) users.getUser(username).getUser();
    }
}

