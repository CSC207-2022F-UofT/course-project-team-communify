package UseCase;
import Database.*;
import Entities.Song;
import InputBoundary.editPlaylistInputBoundary;
import InputData.editPlaylistInputData;
import OutputBoundary.newPlaylistOutputBoundary;
import OutputData.editPlaylistOutputData;

/**
 * Application business rules use case class to edit a playlist.
 */
public class EditPlaylistInteractor implements editPlaylistInputBoundary{

    private final newPlaylistOutputBoundary presenter;
    private final SavePlaylistAccessInterface library;

    private final SaveUserAccessInterface userDatabase;

    /**
     * @param presenter the presenter to output data to the view
     */
    public EditPlaylistInteractor(newPlaylistOutputBoundary presenter){
        this.presenter = presenter;
        this.library = playlistLibrary.getInstance();
        this.userDatabase = userList.getInstance();
    }

    /**
    * @param inputData contains contains information to edit the playlist for removeSong(), addSong(), changePrivacy(),
     *                  and changeName()
     *
    */
    public void removeSong(editPlaylistInputData inputData) {
        //TODO: maybe make this a try-catch ?
        if (inputData.getPlaylist().getOwner() == inputData.getUser()) {
            for (Song s : inputData.getPlaylist().getSongList())
                if (s.getID() == inputData.getSongID()) {
                    inputData.getPlaylist().removeSong(s);
                    break;
                }
        }
        String message = inputData.getSong().getName()+" removed ";
        editPlaylistOutputData outputData = new editPlaylistOutputData(message);
        presenter.setEditPlaylistConfirmation(outputData);

        // save edited playlist
        if (!library.exists(inputData.getPlaylist().getId())){
            this.library.savePlaylist(new playlistDsData(inputData.getPlaylist()));
        }
        // save user
        if (userDatabase.exists(inputData.getPlaylist().getOwner().getUsername())) {
            this.userDatabase.save(new userDsData(inputData.getPlaylist().getOwner()));
        }
    }

    /**
     * @param inputData the data containing playlist and song to add
     */
    public void addSong(editPlaylistInputData inputData){
        if(inputData.getPlaylist().getOwner() == inputData.getUser()) {
            inputData.getPlaylist().addSong(inputData.getSong());
        }
        String message =  inputData.getSong().getName()+" added!";
        editPlaylistOutputData outputData = new editPlaylistOutputData(message);
        presenter.setEditPlaylistConfirmation(outputData);
        //save edited playlist
        if (!library.exists(inputData.getPlaylist().getId())){
            this.library.savePlaylist(new playlistDsData(inputData.getPlaylist()));
        }
        // save user
        if (userDatabase.exists(inputData.getPlaylist().getOwner().getUsername())) {
            this.userDatabase.save(new userDsData(inputData.getPlaylist().getOwner()));
        }
    }
}

