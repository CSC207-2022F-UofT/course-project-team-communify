package outputBoundary;
import outputData.GetArtistSongOutputData;
/**
 * Use case layer output boundary that allows communication between presenters and the artist songs use case.
 */
public interface GetArtistSongOutputBoundary {
    /**
     * @param asod the output data containing an artists songs
     */
    void getTable(GetArtistSongOutputData asod);
}
