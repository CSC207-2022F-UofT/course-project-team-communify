package UseCase;
import Entities.Song;
import Entities.User;

import Entities.Playlist;


public class createPlaylist{

    /**
     @param song will only be used if creating a nonempty playlist with one song
     */
    public Playlist newPlaylist(String playlistName, User Owner, boolean privacy){
        return new Playlist(playlistName, Owner, privacy);
        //empty playlist creation
    }
    public Playlist newPlaylist(String playlistName, User Owner, boolean privacy, Song song){
        return new Playlist(playlistName, Owner, privacy, song);
        //non-empty playlist creation
    }
}

