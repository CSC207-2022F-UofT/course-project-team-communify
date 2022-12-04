package controller;
import inputBoundary.EditSongInputBoundary;
import inputData.UploadSongInputData;
import outputBoundary.EditSongOutputBoundary;
import useCase.EditSongInteractor;
/**
 * Interface adapters layer controller for edit songs use case.
 */
public class EditSongController {

    final EditSongOutputBoundary EditSongPresenter;
    final EditSongInputBoundary editSong;

    /**
     * @param EditSongPresenter the presenter to return edited songs to the view
     */
    public EditSongController(EditSongOutputBoundary EditSongPresenter){
        this.EditSongPresenter = EditSongPresenter;
        this.editSong = new EditSongInteractor(this.EditSongPresenter);
    }

    /**
     * Call the use case to upload a given song.
     * @param uploadSongInputData contains filepath and uploading user.
     */
    public void upload(UploadSongInputData uploadSongInputData){
         editSong.saveSong(uploadSongInputData);
    }

}
