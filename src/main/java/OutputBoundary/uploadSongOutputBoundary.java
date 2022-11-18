package OutputBoundary;
import OutputData.uploadSongOutputData;

/**
 * Use case layer input boundary that allows communication between presenters and the upload use case.
 */
public interface uploadSongOutputBoundary {
    /**
     * @param uploadSongOutputData the output from the upload song use case
     * @return true if and only if the upload was successful
     */
    boolean isUploaded(uploadSongOutputData uploadSongOutputData);
}
