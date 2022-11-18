package Presenter;
import OutputBoundary.uploadSongOutputBoundary;
import OutputData.uploadSongOutputData;
import ViewModel.uploadSongViewModel;

/**
 * Interface adapters layer presenter for displaying upload song use case output.
 */
public class uploadSongPresenter implements uploadSongOutputBoundary{

    private final ViewModel.uploadSongViewModel uploadSongViewModel;

    /**
     * @param uploadSongViewModel the view model for the upload song view
     */
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