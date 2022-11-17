package UseCase;
import Database.playlistDsData;
import Entities.Playlist;
import InputBoundary.newPlaylistInputBoundary;
import InputData.newPlaylistInputData;
import Database.playlistAccessInterface;
import Database.playlistLibrary;
import OutputBoundary.newPlaylistOutputBoundary;
import OutputData.newPlaylistOutputData;

public class CreatePlaylistInteractor implements newPlaylistInputBoundary {
        private final newPlaylistOutputBoundary presenter;

        private final playlistAccessInterface library;
    /**
     *
     * @param presenter presenter object to store output message in
     */
    public CreatePlaylistInteractor(newPlaylistOutputBoundary presenter){
        this.presenter = presenter;
        this.library = playlistLibrary.getInstance();
    }
    /**
     * @param newplaylistInputData holds necessary data to instantiate a new playlist
     * if hasFirstSong() is false, then newPlaylist() will instantiate an empty playlist and vice versa if it's value
     * is true
     */
    public void newPlaylist(newPlaylistInputData newplaylistInputData) {
        Playlist playlist;
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
        this.library.savePlaylist(new playlistDsData(playlist));
        //TODO #2: Regain will to live
        //TODO #3: delete commented lines when finalizing this implementation in a future push

        //generate output data
        newPlaylistOutputData outputData = new newPlaylistOutputData("Playlist created!");

        //set message attribute to output data
        this.presenter.setPlaylistCreationConfirmation(outputData);
    }
}

