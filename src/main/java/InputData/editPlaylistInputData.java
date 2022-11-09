package InputData;
import Entities.Playlist;
import Entities.Song;
import Entities.User;

public class editPlaylistInputData {
    private final Playlist playlist;
    private final Song song;
    private final User user;
    private final boolean privacy;

    private final String newName;

    public editPlaylistInputData(User user, Song song, Playlist playlist, boolean privacy, String newName){
        this.playlist = playlist;
        this.song = song;
        this.user = user;
        this.privacy = privacy;
        this.newName = newName;
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
    public boolean getPrivacy(){
        return this.privacy;
    }
    public String getNewName(){
        return newName;
    }
}

