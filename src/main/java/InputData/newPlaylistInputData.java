package InputData;
import Entities.RegularUser;
import Entities.Song;
import Entities.User;

public class newPlaylistInputData {
    private final int id;
    private final String playlistName;
    private final RegularUser owner;
    //Based off of Assumption that only RegularUser objects can generate playlists
    private final Song firstSong;

    /**
     *
     * @param id ID that is randomly generated in view
     * @param playlistName name of the playlist
     * @param owner RegularUser object because only RegularUser's can create playlists
     */

    public newPlaylistInputData(int id, String playlistName, RegularUser owner){
        this.id = id;
        this.playlistName = playlistName;
        this.owner = owner;
        this.firstSong = null;
    }
    /**
     *
     * @param id ID that is randomly generated in view
     * @param playlistName name of the playlist
     * @param owner RegularUser object because only RegularUser's can create playlists
     * @param firstSong generate this playlist with a singular song
     */
    public newPlaylistInputData(int id, String playlistName, Song firstSong, RegularUser owner){
        this.id = id;
        this.playlistName = playlistName;
        this.owner = owner;
        this.firstSong = firstSong;
    }

    public String getPlaylistName(){
        return this.playlistName;
    }
    public RegularUser getOwner(){
        return this.owner;
    }
    public boolean hasFirstSong(){
        return this.firstSong != null;
    }
    public Song getFirstSong(){
        return this.firstSong;
    }
    public int getId() {
        return this.id;
    }

}
