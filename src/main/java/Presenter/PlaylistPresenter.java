package Presenter;
import OutputBoundary.NewPlaylistOutputBoundary;
import OutputBoundary.EditPlaylistOutputBoundary;
import OutputData.EditPlaylistOutputData;
import OutputData.NewPlaylistOutputData;
import ViewModel.PlaylistViewModel;


public class PlaylistPresenter implements NewPlaylistOutputBoundary, EditPlaylistOutputBoundary {

    private String outputMessage;

    final PlaylistViewModel viewModel;

    /**
     *
     * @param viewModel view model to store output message in
     */
    public PlaylistPresenter(PlaylistViewModel viewModel){
        //this.outputMessage = outputData.getCreatedMessage();
        this.viewModel = viewModel;
        this.outputMessage = "";
    }

    /**
     *
     * @return confirmation of string creation
     */
    public String getOutputMessage(){
        return outputMessage;
    }
    /**
     *
     * @param outputData outputData object containing confirmation message.
     */
    public void setPlaylistCreationConfirmation(NewPlaylistOutputData outputData){
        this.outputMessage = outputData.getCreatedMessage();
        this.viewModel.setOutputMessage(this.outputMessage);
    }

    public void setEditPlaylistConfirmation(EditPlaylistOutputData outputData){
        this.outputMessage = outputData.getPlaylistEditedConfirmation();
        this.viewModel.setOutputMessage(this.outputMessage);
    }
}
