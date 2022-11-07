package InputData;
import Entities.Song;
import Entities.User;
import java.util.Optional;

public class newPlaylistInputData {
    private final String playlistName;
    private final User owner;
    private final Song firstSong;
    private boolean privacy;

    public newPlaylistInputData(String playlistName, User owner, boolean privacy){
        this.playlistName = playlistName;
        this.owner = owner;
        this.firstSong = null;
        this.privacy = privacy;
    }

    public newPlaylistInputData(String playlistName, Song firstSong, User owner, boolean privacy){
        this.playlistName = playlistName;
        this.owner = owner;
        this.firstSong = firstSong;
        this.privacy = privacy;
    }

    public String getPlaylistName(){
        return this.playlistName;
    }
    public User getOwner(){
        return this.owner;
    }
    public boolean hasFirstSong(){
        if(this.firstSong == null){
            return false;
        }
        else{
            return true;
        }
    }
    public Song getFirstSong(){
        return this.firstSong;
    }

    public boolean getPrivacy(){
        return this.privacy;
    }
}
