package Presenter;
import OutputBoundary.uploadSongOutputBoundary;
import OutputData.uploadSongOutputData;

/**
 * Interface adapters layer presenter for displaying upload song use case output.
 */
public class uploadSongPresenter implements uploadSongOutputBoundary{
    /**
     * @param uploadSongOutputData the output from the upload song use case
     * @return true if and only if the upload is successful
     */
    public boolean isUploaded(uploadSongOutputData uploadSongOutputData) {
        return uploadSongOutputData.getSuccess();
    }
}