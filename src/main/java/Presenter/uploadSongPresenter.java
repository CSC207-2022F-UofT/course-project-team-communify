package Presenter;
import OutputBoundary.uploadSongOutputBoundary;
import OutputData.uploadSongOutputData;

public class uploadSongPresenter implements uploadSongOutputBoundary{
    public boolean isUploaded(uploadSongOutputData uploadSongOutputData) {
        return uploadSongOutputData.getSuccess();
    }
}