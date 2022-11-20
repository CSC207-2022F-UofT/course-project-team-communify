package UseCase;
import Entities.Song;
import InputBoundary.EditPlaylistInputBoundary;
import InputData.EditPlaylistInputData;
import OutputBoundary.NewPlaylistOutputBoundary;
import OutputData.EditPlaylistOutputData;

public class EditPlaylistInteractor implements EditPlaylistInputBoundary {

    private final NewPlaylistOutputBoundary presenter;

    public EditPlaylistInteractor(NewPlaylistOutputBoundary presenter){
        this.presenter = presenter;
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
        String message = inputData.getSong().getName()+" removed!";
        EditPlaylistOutputData outputData = new EditPlaylistOutputData(message);
        presenter.setEditPlaylistConfirmation(outputData);
    }
    public void addSong(EditPlaylistInputData inputData){
        if(inputData.getPlaylist().getOwner() == inputData.getUser()) {
            inputData.getPlaylist().addSong(inputData.getSong());
        }
        String message =  inputData.getSong().getName()+" added!";
        EditPlaylistOutputData outputData = new EditPlaylistOutputData(message);
        presenter.setEditPlaylistConfirmation(outputData);
    }
}

