package Presenter;
import OutputBoundary.uploadSongOutputBoundary;
import OutputData.uploadSongOutputData;
import ViewModel.uploadSongViewModel;

public class uploadSongPresenter implements uploadSongOutputBoundary{

    private final ViewModel.uploadSongViewModel uploadSongViewModel;

    public uploadSongPresenter(uploadSongViewModel uploadSongViewModel){
        this.uploadSongViewModel = uploadSongViewModel;
    }

    /**
     * Informs the viewModel whether a song has been uploaded.
     * @param uploadSongOutputData bundles a boolean representing whether or not the upload was a success.
     */
    public void isUploaded(uploadSongOutputData uploadSongOutputData) {
        this.uploadSongViewModel.updateIsUploaded(uploadSongOutputData.getSuccess());
    }
}