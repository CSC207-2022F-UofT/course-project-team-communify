package UseCase;
import Database.*;
import Entities.Playlist;
import InputBoundary.newPlaylistInputBoundary;
import InputData.newPlaylistInputData;
import OutputBoundary.newPlaylistOutputBoundary;
import OutputData.newPlaylistOutputData;

/**
 * Application business rules use case class to create a new playlist.
 */
public class CreatePlaylistInteractor implements newPlaylistInputBoundary {
        private final newPlaylistOutputBoundary presenter;

        private final SavePlaylistAccessInterface library;

        private final SaveUserAccessInterface userDatabase;
    /**
     *
     * @param presenter presenter object to store output message in
     */
    public CreatePlaylistInteractor(newPlaylistOutputBoundary presenter){
        this.presenter = presenter;
        this.library = playlistLibrary.getInstance();
        this.userDatabase = userList.getInstance();
    }
    /**
     * @param newplaylistInputData holds necessary data to instantiate a new playlist
     * if hasFirstSong() is false, then newPlaylist() will instantiate an empty playlist and vice versa if it's value
     * is true
     */
    public void newPlaylist(newPlaylistInputData newplaylistInputData) {
        Playlist playlist;
        String successMessage;
        if (!newplaylistInputData.hasFirstSong()) {
            playlist = new Playlist(newplaylistInputData.getId(), newplaylistInputData.getPlaylistName(),
                    newplaylistInputData.getOwner());
            successMessage = "Playlist created!";
        }
        else{
            playlist = new Playlist(newplaylistInputData.getId(), newplaylistInputData.getPlaylistName(),
                    newplaylistInputData.getOwner(),
                     newplaylistInputData.getFirstSong());
            successMessage = "Playlist created with "+ newplaylistInputData.getFirstSong().getName()+"!";
        }
        newplaylistInputData.getOwner().addPlaylist(playlist);
        // save the newly created playlist to the RegularUser's playlist list
        if (!library.exists(playlist.getId())){
            this.library.savePlaylist(new playlistDsData(playlist));
        }
        // save user
        if (userDatabase.exists(playlist.getOwner().getUsername())) {
            this.userDatabase.save(new userDsData(playlist.getOwner()));
        }
        //generate output data
        newPlaylistOutputData outputData = new newPlaylistOutputData(successMessage);

        //set message attribute to output data
        this.presenter.setPlaylistCreationConfirmation(outputData);
    }
}

