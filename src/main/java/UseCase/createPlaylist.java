package UseCase;
import Database.playlistDsData;
import Entities.Playlist;
import InputBoundary.newPlaylistInputBoundary;
import InputData.newPlaylistInputData;
import Database.playlistAccessInterface;
import Database.playlistLibrary;

import OutputData.newPlaylistOutputData;
import OutputBoundary.newPlaylistOutputBoundary;

public class createPlaylist implements newPlaylistInputBoundary {

    private final newPlaylistOutputBoundary newPlaylistOutputBoundary;
    public createPlaylist(newPlaylistOutputBoundary newPlaylistOutputBoundary){
        this.newPlaylistOutputBoundary = newPlaylistOutputBoundary;
    }
    /**
     * @param newplaylistInputData holds necessary data to instantiate a new playlist
     * if hasFirstSong() is false, then newPlaylist() will instantiate an empty playlist and vice versa if it's value
     * is true
     */
    public void newPlaylist(newPlaylistInputData newplaylistInputData) {
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

        // TODO: new potential implementation of sending confirmation message via outputdata, check correctness
        newPlaylistOutputData outputData = new newPlaylistOutputData("Playlist created!");
        this.newPlaylistOutputBoundary.playlistCreationConfirmation(outputData);
        //return "Playlist created!";
    }
}

