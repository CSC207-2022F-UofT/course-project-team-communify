package Presenter;

import OutputBoundary.getArtistSongOutputBoundary;
import OutputData.getArtistSongOutputData;
import ViewModel.ArtistViewModel;

public class getArtistSongPresenter implements getArtistSongOutputBoundary {

    private final ArtistViewModel artistViewModel;

    public getArtistSongPresenter(ArtistViewModel artistViewModel){
        this.artistViewModel = artistViewModel;
    }

    public void getTable(getArtistSongOutputData asod){
        this.artistViewModel.updateSongTable(asod.getTable());
    }

}
