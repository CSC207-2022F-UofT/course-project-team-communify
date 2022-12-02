package Presenter;

import OutputBoundary.GetArtistSongOutputBoundary;
import OutputData.GetArtistSongOutputData;
import ViewModel.ArtistViewModel;
/**
 * Interface adapters layer presenter for displaying artist playlists use case output.
 */
public class GetArtistSongPresenter implements GetArtistSongOutputBoundary {

    private final ArtistViewModel artistViewModel;

    /**
     * @param artistViewModel the view model for outputting artist data
     */
    public GetArtistSongPresenter(ArtistViewModel artistViewModel){
        this.artistViewModel = artistViewModel;
    }

    /**
     * @param asod the output data containing an artists songs
     */
    public void getTable(GetArtistSongOutputData asod){
        this.artistViewModel.updateSongTable(asod.getTable());
    }

}
