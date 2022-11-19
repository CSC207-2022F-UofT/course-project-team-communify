package Presenter;
import OutputBoundary.EditSongOutputBoundary;
import OutputData.EditSongOutputData;
import ViewModel.EditSongViewModel;

public class EditSongPresenter implements EditSongOutputBoundary {

    private final EditSongViewModel EditSongViewModel;

    public EditSongPresenter(EditSongViewModel EditSongViewModel){
        this.EditSongViewModel = EditSongViewModel;
    }

    /**
     * Informs the viewModel whether a song has been uploaded.
     * @param EditSongOutputData bundles a boolean representing whether the upload was a success.
     */
    @Override
    public void isUploaded(EditSongOutputData EditSongOutputData) {
        this.EditSongViewModel.updateIsUploaded(EditSongOutputData.getSuccess());
    }

    /**
     * Informs the viewModel whether a song has been deleted.
     * @param EditSongOutputData bundles a boolean representing whether the deletion was a success.
     */
    @Override
    public void isDeleted(EditSongOutputData EditSongOutputData) {
        this.EditSongViewModel.updateIsDeleted(EditSongOutputData.getSuccess());
    }

}