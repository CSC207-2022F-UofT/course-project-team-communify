package presenter;
import outputBoundary.EditSongOutputBoundary;
import outputData.EditSongOutputData;
import viewModel.ArtistViewModel;
/**
 * Interface adapters layer presenter for displaying edit song use case output.
 */
public class EditSongPresenter implements EditSongOutputBoundary {

    private final ArtistViewModel EditSongViewModel;

    /**
     * @param EditSongViewModel the view model for outputting artist data
     */
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