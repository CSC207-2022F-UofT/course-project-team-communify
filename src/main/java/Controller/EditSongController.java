package Controller;
import InputBoundary.EditSongInputBoundary;
import InputData.UploadSongInputData;
import OutputBoundary.EditSongOutputBoundary;
import UseCase.EditSongInteractor;

public class EditSongController {

    EditSongOutputBoundary EditSongPresenter;
    EditSongInputBoundary editSong;

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
