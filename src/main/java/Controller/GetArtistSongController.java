package Controller;

import InputBoundary.GetArtistSongInputBoundary;
import InputData.GetArtistSongInputData;
import OutputBoundary.GetArtistSongOutputBoundary;
import UseCase.GetArtistSongInteractor;
/**
 * Interface adapters layer controller for get artists use case.
 */
public class GetArtistSongController {

    GetArtistSongOutputBoundary getArtistSongPresenter;
    GetArtistSongInputBoundary getSong;

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
