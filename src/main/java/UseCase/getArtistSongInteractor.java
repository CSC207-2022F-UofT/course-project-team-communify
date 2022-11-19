package UseCase;
import Database.SaveSongAccessInterface;
import InputBoundary.getArtistSongInputBoundary;
import InputData.getArtistSongInputData;
import OutputBoundary.getArtistSongOutputBoundary;
import OutputData.getArtistSongOutputData;

public class getArtistSongInteractor implements getArtistSongInputBoundary {

    private final SaveSongAccessInterface songLibrary;
    private final getArtistSongOutputBoundary getArtistSongPresenter;

    public getArtistSongInteractor(getArtistSongOutputBoundary getArtistSongPresenter){
        this.songLibrary = Database.songLibrary.getInstance();
        this.getArtistSongPresenter = getArtistSongPresenter;
    }

    public void getArtistSong(getArtistSongInputData asid){
        String[][] table = songLibrary.getString(asid.getUsername());
        getArtistSongPresenter.getTable(new getArtistSongOutputData(table));
    }

}
