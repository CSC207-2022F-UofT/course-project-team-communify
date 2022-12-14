package useCase;
import database.*;
import entities.Playlist;
import inputBoundary.NewPlaylistInputBoundary;
import inputData.NewPlaylistInputData;
import outputBoundary.NewPlaylistOutputBoundary;
import outputData.NewPlaylistOutputData;

/**
 * Application business rules use case class to create a new playlist.
 */
public class CreatePlaylistInteractor implements NewPlaylistInputBoundary {
        private final NewPlaylistOutputBoundary presenter;

        private final SavePlaylistAccessInterface library;

        private final SaveUserAccessInterface userDatabase;
    /**
     *
     * @param presenter presenter object to store output message in
     */
    public CreatePlaylistInteractor(NewPlaylistOutputBoundary presenter){
        this.presenter = presenter;
        this.library = PlaylistLibrary.getInstance();
        this.userDatabase = UserList.getInstance();
    }
    /**
     * @param newPlaylistInputData holds necessary data to instantiate a new playlist
     * if hasFirstSong() is false, then newPlaylist() will instantiate an empty playlist and vice versa if it's value
     * is true
     */
    public void newPlaylist(NewPlaylistInputData newPlaylistInputData) {
        Playlist playlist;
        String successMessage;
        if (!newPlaylistInputData.hasFirstSong()) {
            playlist = new Playlist(newPlaylistInputData.getId(), newPlaylistInputData.getPlaylistName(),
                    newPlaylistInputData.getOwner());
            newPlaylistInputData.getOwner().addPlaylist(playlist);
            successMessage = "Playlist created!";
        }
        else{
            playlist = new Playlist(newPlaylistInputData.getId(), newPlaylistInputData.getPlaylistName(),
                    newPlaylistInputData.getOwner(),
                     newPlaylistInputData.getFirstSong());
            newPlaylistInputData.getOwner().addPlaylist(playlist);
            successMessage = "Playlist created with "+ newPlaylistInputData.getFirstSong().getName()+"!";
        }
        newPlaylistInputData.getOwner().addPlaylist(playlist);
        // save the newly created playlist to the RegularUser's playlist list
        if (!library.exists(playlist.getId())){
            this.library.savePlaylist(new PlaylistDsData(playlist));
        }
        // save user
        if (userDatabase.exists(playlist.getOwner().getUsername())) {
            this.userDatabase.save(new UserDsData(playlist.getOwner()));
        }
        //generate output data
        NewPlaylistOutputData outputData = new NewPlaylistOutputData(successMessage);

        //set message attribute to output data
        this.presenter.setPlaylistCreationConfirmation(outputData);
    }
}

