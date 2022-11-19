package InputData;
import Entities.Playlist;
import Entities.Song;
import Entities.User;

public class editPlaylistInputData {
    private final Playlist playlist;
    private final Song song;
    private final User user;

    public editPlaylistInputData(User user, Playlist playlist, Song song){
        this.playlist = playlist;
        this.song = song;
        this.user = user;
    }
    public int getSongID(){
        return this.song.getID();
    }
    public User getUser(){
        return this.user;
    }
    public Playlist getPlaylist(){
        return this.playlist;
    }
    public Song getSong(){
        return this.song;
    }
}

