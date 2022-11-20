package Presenter;
import OutputBoundary.UploadSongOutputBoundary;
import OutputData.UploadSongOutputData;
import ViewModel.UploadSongViewModel;

public class UploadSongPresenter implements UploadSongOutputBoundary {

    private final UploadSongViewModel uploadSongViewModel;

    public UploadSongPresenter(UploadSongViewModel uploadSongViewModel){
        this.uploadSongViewModel = uploadSongViewModel;
    }

    /**
     * Informs the viewModel whether a song has been uploaded.
     * @param uploadSongOutputData bundles a boolean representing whether or not the upload was a success.
     */
    public void isUploaded(UploadSongOutputData uploadSongOutputData) {
        this.uploadSongViewModel.updateIsUploaded(uploadSongOutputData.getSuccess());
    }
}