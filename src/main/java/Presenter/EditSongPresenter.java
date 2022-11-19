package Presenter;
import OutputBoundary.EditSongOutputBoundary;
import OutputData.EditSongOutputData;
import ViewModel.ArtistViewModel;

public class EditSongPresenter implements EditSongOutputBoundary {

    private final ArtistViewModel EditSongViewModel;

    public EditSongPresenter(ArtistViewModel EditSongViewModel){
        this.EditSongViewModel = EditSongViewModel;
    }

    /**
     * Informs the viewModel whether a song has been uploaded.
     * @param esod bundles a boolean representing whether the upload was a success.
     */
    @Override
    public void isUploaded(EditSongOutputData esod){
        this.EditSongViewModel.updateIsUploaded(esod.getSuccess());
    }


}