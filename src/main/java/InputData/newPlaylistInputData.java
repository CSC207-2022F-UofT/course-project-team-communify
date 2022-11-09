package InputData;
import Entities.Song;
import Entities.User;

public class newPlaylistInputData {
    private final int id;
    private final String playlistName;
    private final User owner;
    private final Song firstSong;


    public newPlaylistInputData(int id, String playlistName, User owner){
        this.id = id;
        this.playlistName = playlistName;
        this.owner = owner;
        this.firstSong = null;
    }

    public newPlaylistInputData(int id, String playlistName, Song firstSong, User owner){
        this.id = id;
        this.playlistName = playlistName;
        this.owner = owner;
        this.firstSong = firstSong;
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
    public int getId() {
        return id;
    }

}
