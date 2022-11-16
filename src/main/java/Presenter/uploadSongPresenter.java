package Presenter;
import OutputBoundary.uploadSongOutputBoundary;
import OutputData.uploadSongOutputData;
import ViewModel.uploadSongViewModel;

public class uploadSongPresenter implements uploadSongOutputBoundary{

    private final ViewModel.uploadSongViewModel uploadSongViewModel;

    public uploadSongPresenter(uploadSongViewModel uploadSongViewModel){
        this.uploadSongViewModel = uploadSongViewModel;
    }

    public void isUploaded(uploadSongOutputData uploadSongOutputData) {
        this.uploadSongViewModel.updateIsUploaded(uploadSongOutputData.getSuccess());
    }
}