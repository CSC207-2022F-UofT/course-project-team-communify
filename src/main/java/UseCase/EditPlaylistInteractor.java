package UseCase;
import Database.*;
import Entities.Song;
import InputBoundary.EditPlaylistInputBoundary;
import InputData.EditPlaylistInputData;
import OutputBoundary.NewPlaylistOutputBoundary;
import OutputData.EditPlaylistOutputData;

/**
 * Application business rules use case class to edit a playlist.
 */
public class EditPlaylistInteractor implements EditPlaylistInputBoundary {

    private final NewPlaylistOutputBoundary presenter;
    private final SavePlaylistAccessInterface library;

    private final SaveUserAccessInterface userDatabase;

    /**
     * @param presenter the presenter to output data to the view
     */
    public EditPlaylistInteractor(NewPlaylistOutputBoundary presenter){
        this.presenter = presenter;
        this.library = PlaylistLibrary.getInstance();
        this.userDatabase = UserList.getInstance();
    }

    /**
    * @param inputData contains contains information to edit the playlist for removeSong(), addSong(), changePrivacy(),
     *                  and changeName()
     *
    */
    public void removeSong(EditPlaylistInputData inputData) {
        //TODO: maybe make this a try-catch ?
        if (inputData.getPlaylist().getOwner() == inputData.getUser()) {
            for (Song s : inputData.getPlaylist().getSongList())
                if (s.getID() == inputData.getSongID()) {
                    inputData.getPlaylist().removeSong(s);
                    break;
                }
        }
        String message = inputData.getSong().getName() + " removed!";
        EditPlaylistOutputData outputData = new EditPlaylistOutputData(message, inputData.getPlaylist());
        presenter.setEditPlaylistConfirmation(outputData);

        // save edited playlist
        if (library.exists(inputData.getPlaylist().getId())){
            this.library.savePlaylist(new PlaylistDsData(inputData.getPlaylist()));
        }
        // save user
        if (userDatabase.exists(inputData.getPlaylist().getOwner().getUsername())) {
            this.userDatabase.save(new UserDsData(inputData.getPlaylist().getOwner()));
        }
    }

    /**
     * @param inputData the data containing playlist and song to add
     */
    public void addSong(EditPlaylistInputData inputData){
        if(inputData.getPlaylist().getOwner() == inputData.getUser()) {
            inputData.getPlaylist().addSong(inputData.getSong());
        }
        String message =  inputData.getSong().getName() + " added!";
        EditPlaylistOutputData outputData = new EditPlaylistOutputData(message, inputData.getPlaylist());
        presenter.setEditPlaylistConfirmation(outputData);
        //save edited playlist
        if (library.exists(inputData.getPlaylist().getId())){
            this.library.savePlaylist(new PlaylistDsData(inputData.getPlaylist()));
        }
        // save user
        if (userDatabase.exists(inputData.getPlaylist().getOwner().getUsername())) {
            this.userDatabase.save(new UserDsData(inputData.getPlaylist().getOwner()));
        }
    }
}

