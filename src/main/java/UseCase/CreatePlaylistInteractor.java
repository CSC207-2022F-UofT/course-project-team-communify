package UseCase;
import Database.*;
import Entities.Playlist;
import InputBoundary.newPlaylistInputBoundary;
import InputData.newPlaylistInputData;
import OutputBoundary.newPlaylistOutputBoundary;
import OutputData.newPlaylistOutputData;

public class CreatePlaylistInteractor implements newPlaylistInputBoundary {
        private final newPlaylistOutputBoundary presenter;

        private final playlistAccessInterface library;

        private final userAccessInterface userDatabase;
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
        if (!newplaylistInputData.hasFirstSong()) {
            playlist = new Playlist(newplaylistInputData.getId(), newplaylistInputData.getPlaylistName(),
                    newplaylistInputData.getOwner());
        }
        else{
            playlist = new Playlist(newplaylistInputData.getId(), newplaylistInputData.getPlaylistName(), newplaylistInputData.getOwner(),
                     newplaylistInputData.getFirstSong());
        }
        //Add the play;ist to the Owner's playlist list
        newplaylistInputData.getOwner().addPlaylist(playlist);
        //Set the playlist's owner to the user
        playlist.setOwner(newplaylistInputData.getOwner());
        // save the newly created playlist to the RegularUser's playlist list
        this.library.savePlaylist(new playlistDsData(playlist));
        // save user

        //this.userDatabase.save(new userDsData(playlist.getOwner()));
        //TODO: null pointer exception in view, user isnt saving ?
        this.userDatabase.save(new userDsData(newplaylistInputData.getOwner()));
        //TODO figure out hard dependency.
        //generate output data
        newPlaylistOutputData outputData = new newPlaylistOutputData("Playlist created!");

        //set message attribute to output data
        this.presenter.setPlaylistCreationConfirmation(outputData);
    }
}

