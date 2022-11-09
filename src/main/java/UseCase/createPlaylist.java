package UseCase;
import Database.playlistDsData;
import Entities.Playlist;
import InputBoundary.newPlaylistInputBoundary;
import InputData.newPlaylistInputData;
import Database.playlistAccessInterface;
import Database.playlistLibrary;
public class createPlaylist implements newPlaylistInputBoundary {

    /**
     * @param playlistInputData holds necessary data to instantiate a new playlist
     * if hasFirstSong() is false, then newPlaylist() will instantiate an empty playlist and vice versa if it's value
     * is true
     */
    public String newPlaylist(newPlaylistInputData playlistInputData) {
        Playlist playlist;
        playlistAccessInterface library = playlistLibrary.getInstance();
        if (!playlistInputData.hasFirstSong()) {
            playlist = new Playlist(playlistInputData.getId(), playlistInputData.getPlaylistName(), playlistInputData.getOwner()
                    );

        }
        else{
            playlist = new Playlist(playlistInputData.getId(), playlistInputData.getPlaylistName(), playlistInputData.getOwner(),
                     playlistInputData.getFirstSong());
        }
        library.savePlaylist(new playlistDsData(playlist));
        return "Playlist created!";
    }
}

