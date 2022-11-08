package InputData;
import Entities.Song;
import Entities.User;

public class newPlaylistInputData {
    private final String playlistName;
    private final User owner;
    private final Song firstSong;
    private boolean isPrivate;

    public newPlaylistInputData(String playlistName, User owner, boolean privacy){
        this.playlistName = playlistName;
        this.owner = owner;
        this.firstSong = null;
        this.isPrivate = privacy;
    }

    public newPlaylistInputData(String playlistName, Song firstSong, User owner, boolean privacy){
        this.playlistName = playlistName;
        this.owner = owner;
        this.firstSong = firstSong;
        this.isPrivate = privacy;
    }

    public String getPlaylistName(){
        return this.playlistName;
    }
    public User getOwner(){
        return this.owner;
    }
    public boolean hasFirstSong(){
        return this.firstSong != null;
    }
    public Song getFirstSong(){
        return this.firstSong;
    }

    public boolean getPrivacy(){
        return this.isPrivate;
    }
}
