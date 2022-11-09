package UseCase;
import Entities.Playlist;
import InputBoundary.newPlaylistInputBoundary;
import InputData.newPlaylistInputData;
public class createPlaylist implements newPlaylistInputBoundary {

    /**
     * @param playlistInputData holds necessary data to instantiate a new playlist
     * if hasFirstSong() is false, then newPlaylist() will instantiate an empty playlist and vice versa if it's value
     * is true
     */
    public Playlist newPlaylist(newPlaylistInputData playlistInputData) {
        if (!playlistInputData.hasFirstSong()) {
            return new Playlist(playlistInputData.getId(), playlistInputData.getPlaylistName(), playlistInputData.getOwner()
                    );

        }
        else{
            return new Playlist(playlistInputData.getId(), playlistInputData.getPlaylistName(), playlistInputData.getOwner(),
                     playlistInputData.getFirstSong());
        }
    }
}

