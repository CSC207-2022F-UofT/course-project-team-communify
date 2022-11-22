package Controller;

import InputBoundary.getArtistSongInputBoundary;
import InputData.getArtistSongInputData;
import OutputBoundary.getArtistSongOutputBoundary;
import UseCase.getArtistSongInteractor;
/**
 * Interface adapters layer controller for get artists use case.
 */
public class getArtistSongController {

    getArtistSongOutputBoundary getArtistSongPresenter;
    getArtistSongInputBoundary getSong;

    /**
     * @param getArtistSongPresenter the presenter to return artist data to the view
     */
    public getArtistSongController(getArtistSongOutputBoundary getArtistSongPresenter){
        this.getArtistSongPresenter = getArtistSongPresenter;
        this.getSong = new getArtistSongInteractor(this.getArtistSongPresenter);
    }

    /**
     * @param asid the artist song ID input data
     */
    public void getSong(getArtistSongInputData asid){
        getSong.getArtistSong(asid);
    }
}
