package controller;
import inputBoundary.GetArtistSongInputBoundary;
import inputData.GetArtistSongInputData;
import outputBoundary.GetArtistSongOutputBoundary;
import useCase.GetArtistSongInteractor;
/**
 * Interface adapters layer controller for get artists use case.
 */
public class GetArtistSongController {

    final GetArtistSongOutputBoundary getArtistSongPresenter;
    final GetArtistSongInputBoundary getSong;

    /**
     * @param getArtistSongPresenter the presenter to return artist data to the view
     */
    public GetArtistSongController(GetArtistSongOutputBoundary getArtistSongPresenter){
        this.getArtistSongPresenter = getArtistSongPresenter;
        this.getSong = new GetArtistSongInteractor(this.getArtistSongPresenter);
    }

    /**
     * @param asid the artist song ID input data
     */
    public void getSong(GetArtistSongInputData asid){
        getSong.getArtistSong(asid);
    }
}
