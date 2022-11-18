package InputData;
import Entities.Playlist;
import Entities.Song;
import Entities.User;

/**
 * Application Business Rules layer data structure for submitting playlist input to use cases.
 */
public class editPlaylistInputData {
    private final Playlist playlist;
    private final Song song;
    private final User user;

    /**
     * @param user User which owns the playlist
     * @param playlist Playlist to be edited
     * @param song Song to be added/removed from the Playlist
     */
    public editPlaylistInputData(User user, Playlist playlist, Song song){
        this.playlist = playlist;
        this.song = song;
        this.user = user;
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
}

