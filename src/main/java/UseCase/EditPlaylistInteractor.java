package UseCase;
import Entities.Song;
import InputBoundary.editPlaylistInputBoundary;
import InputData.editPlaylistInputData;
import OutputBoundary.newPlaylistOutputBoundary;
import OutputData.editPlaylistOutputData;

public class EditPlaylistInteractor implements editPlaylistInputBoundary{

    private final newPlaylistOutputBoundary presenter;

    public EditPlaylistInteractor(newPlaylistOutputBoundary presenter){
        this.presenter = presenter;
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
    }
    public void addSong(editPlaylistInputData inputData){
        if(inputData.getPlaylist().getOwner() == inputData.getUser()) {
            inputData.getPlaylist().addSong(inputData.getSong());
        }
        String message =  inputData.getSong().getName()+" added!";
        editPlaylistOutputData outputData = new editPlaylistOutputData(message);
        presenter.setEditPlaylistConfirmation(outputData);
    }
}

