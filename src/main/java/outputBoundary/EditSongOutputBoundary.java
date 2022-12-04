package outputBoundary;
import outputData.EditSongOutputData;
/**
 * Use case layer output boundary that allows communication between presenters and the edit song use case.
 */
public interface EditSongOutputBoundary {
    /**
     * @param editSongOutputData the output data containing a song to be edited
     */
    void isUploaded(EditSongOutputData editSongOutputData);

}
