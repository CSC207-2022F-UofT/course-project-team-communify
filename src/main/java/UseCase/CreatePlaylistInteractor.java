package UseCase;
import Database.*;
import Entities.Playlist;
import InputBoundary.NewPlaylistInputBoundary;
import InputData.NewPlaylistInputData;
import OutputBoundary.NewPlaylistOutputBoundary;
import OutputData.NewPlaylistOutputData;

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
     * @param newplaylistInputData holds necessary data to instantiate a new playlist
     * if hasFirstSong() is false, then newPlaylist() will instantiate an empty playlist and vice versa if it's value
     * is true
     */
    public void newPlaylist(NewPlaylistInputData newplaylistInputData) {
        Playlist playlist;
        NewPlaylistOutputData outputData;
        if (!newplaylistInputData.hasFirstSong()) {
            playlist = new Playlist(newplaylistInputData.getId(), newplaylistInputData.getPlaylistName(),
                    newplaylistInputData.getOwner());
            outputData = new NewPlaylistOutputData("Playlist created!");
        }
        else{
            playlist = new Playlist(newplaylistInputData.getId(), newplaylistInputData.getPlaylistName(), newplaylistInputData.getOwner(),
                     newplaylistInputData.getFirstSong());
            outputData = new NewPlaylistOutputData("Playlist Created With One Song!");
        }
        newplaylistInputData.getOwner().addPlaylist(playlist);
        // save the newly created playlist to the RegularUser's playlist list
        if (!library.exists(playlist.getId())){
            this.library.savePlaylist(new PlaylistDsData(playlist));
        }
        // save user
        if (userDatabase.exists(playlist.getOwner().getUsername())) {
            this.userDatabase.save(new UserDsData(playlist.getOwner()));
        }
        //TODO #2: Regain will to live
        //TODO #3: delete commented lines when finalizing this implementation in a future push
        //generate output data
//        newPlaylistOutputData outputData = new newPlaylistOutputData("Playlist created!");

        //set message attribute to output data
        this.presenter.setPlaylistCreationConfirmation(outputData);
    }
}

