package UseCase;
import Database.playlistDsData;
import Entities.Playlist;
import InputBoundary.newPlaylistInputBoundary;
import InputData.newPlaylistInputData;
import Database.playlistAccessInterface;
import Database.playlistLibrary;
public class createPlaylist implements newPlaylistInputBoundary {

    /**
     * @param newplaylistInputData holds necessary data to instantiate a new playlist
     * if hasFirstSong() is false, then newPlaylist() will instantiate an empty playlist and vice versa if it's value
     * is true
     */
    public String newPlaylist(newPlaylistInputData newplaylistInputData) {
        Playlist playlist;
        playlistAccessInterface library = playlistLibrary.getInstance();
        if (!newplaylistInputData.hasFirstSong()) {
            playlist = new Playlist(newplaylistInputData.getId(), newplaylistInputData.getPlaylistName(),
                    newplaylistInputData.getOwner());
        }
        else{
            playlist = new Playlist(newplaylistInputData.getId(), newplaylistInputData.getPlaylistName(), newplaylistInputData.getOwner(),
                     newplaylistInputData.getFirstSong());
        }
        newplaylistInputData.getOwner().addPlaylist(playlist);
        // save the newly created playlist to the RegularUser's playlist list
        library.savePlaylist(new playlistDsData(playlist));
        return "Playlist created!";
    }
}

