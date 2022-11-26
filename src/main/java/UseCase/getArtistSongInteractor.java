package UseCase;
import Database.SaveSongAccessInterface;
import InputBoundary.getArtistSongInputBoundary;
import InputData.getArtistSongInputData;
import OutputBoundary.getArtistSongOutputBoundary;
import OutputData.getArtistSongOutputData;

/**
 * Application business rules use case class to get an artists songs.
 */
public class getArtistSongInteractor implements getArtistSongInputBoundary {

    private final SaveSongAccessInterface songLibrary;
    private final getArtistSongOutputBoundary getArtistSongPresenter;

    /**
     * @param getArtistSongPresenter the presenter for artist song output
     */
    public getArtistSongInteractor(getArtistSongOutputBoundary getArtistSongPresenter){
        this.songLibrary = Database.songLibrary.getInstance();
        this.getArtistSongPresenter = getArtistSongPresenter;
    }

    /**
     * @param asid the artist's song IDs
     */
    public void getArtistSong(getArtistSongInputData asid){
        String[][] table = songLibrary.getString(asid.getUsername());
        getArtistSongPresenter.getTable(new getArtistSongOutputData(table));
    }

}
