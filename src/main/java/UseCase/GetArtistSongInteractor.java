package useCase;
import database.SaveSongAccessInterface;
import database.SongLibrary;
import inputBoundary.GetArtistSongInputBoundary;
import inputData.GetArtistSongInputData;
import outputBoundary.GetArtistSongOutputBoundary;
import outputData.GetArtistSongOutputData;

/**
 * Application business rules use case class to get an artists songs.
 */
public class GetArtistSongInteractor implements GetArtistSongInputBoundary {

    private final SaveSongAccessInterface songLibrary;
    private final GetArtistSongOutputBoundary getArtistSongPresenter;

    /**
     * @param getArtistSongPresenter the presenter for artist song output
     */
    public GetArtistSongInteractor(GetArtistSongOutputBoundary getArtistSongPresenter){
        this.songLibrary = SongLibrary.getInstance();
        this.getArtistSongPresenter = getArtistSongPresenter;
    }

    /**
     * @param asid the artist's song IDs
     */
    public void getArtistSong(GetArtistSongInputData asid){
        String[][] table = songLibrary.getString(asid.getUsername());
        getArtistSongPresenter.getTable(new GetArtistSongOutputData(table));
    }

}
