package InputData;
import Entities.RegularUser;
import Entities.Song;

/**
 * Application Business Rules layer data structure for submitting new playlist input to use cases.
 */
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

}
