package UseCase;
import Database.SaveSongAccessInterface;
import Database.SongLibrary;
import InputBoundary.GetArtistSongInputBoundary;
import InputData.GetArtistSongInputData;
import OutputBoundary.GetArtistSongOutputBoundary;
import OutputData.GetArtistSongOutputData;

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
