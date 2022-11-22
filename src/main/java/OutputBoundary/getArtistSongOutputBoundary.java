package OutputBoundary;
import OutputData.getArtistSongOutputData;
/**
 * Use case layer output boundary that allows communication between presenters and the artist songs use case.
 */
public interface getArtistSongOutputBoundary {
    /**
     * @param asod the output data containing an artists songs
     */
    void getTable(getArtistSongOutputData asod);
}
