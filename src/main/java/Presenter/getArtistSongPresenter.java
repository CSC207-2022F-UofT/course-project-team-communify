package Presenter;

import OutputBoundary.getArtistSongOutputBoundary;
import OutputData.getArtistSongOutputData;
import ViewModel.ArtistViewModel;
/**
 * Interface adapters layer presenter for displaying artist playlists use case output.
 */
public class getArtistSongPresenter implements getArtistSongOutputBoundary {

    private final ArtistViewModel artistViewModel;

    /**
     * @param artistViewModel the view model for outputting artist data
     */
    public getArtistSongPresenter(ArtistViewModel artistViewModel){
        this.artistViewModel = artistViewModel;
    }

    /**
     * @param asod the output data containing an artists songs
     */
    public void getTable(getArtistSongOutputData asod){
        this.artistViewModel.updateSongTable(asod.getTable());
    }

}
