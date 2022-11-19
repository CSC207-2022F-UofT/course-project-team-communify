package Controller;

import InputBoundary.getArtistSongInputBoundary;
import InputData.getArtistSongInputData;
import OutputBoundary.getArtistSongOutputBoundary;
import UseCase.getArtistSongInteractor;

public class getArtistSongController {

    getArtistSongOutputBoundary getArtistSongPresenter;
    getArtistSongInputBoundary getSong;

    public getArtistSongController(getArtistSongOutputBoundary getArtistSongPresenter){
        this.getArtistSongPresenter = getArtistSongPresenter;
        this.getSong = new getArtistSongInteractor(this.getArtistSongPresenter);
    }

    public void getSong(getArtistSongInputData asid){
        getSong.getArtistSong(asid);
    }
}
