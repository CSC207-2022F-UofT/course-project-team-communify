package Presenter;
import OutputBoundary.newPlaylistOutputBoundary;
import OutputBoundary.editPlaylistOutputBoundary;
import OutputData.editPlaylistOutputData;
import OutputData.newPlaylistOutputData;
import ViewModel.playlistViewModel;

/**
 * Interface adapters layer presenter for displaying edit playlists use case output.
 */
public class playlistPresenter implements newPlaylistOutputBoundary,editPlaylistOutputBoundary {

    private String outputMessage;

    final playlistViewModel viewModel;

    /**
     *
     * @param viewModel view model to store output message in
     */
    public playlistPresenter(playlistViewModel viewModel){
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
     * @param outputData outputData object containing confirmation message.
     */
    public void setPlaylistCreationConfirmation(newPlaylistOutputData outputData){
        this.outputMessage = outputData.getCreatedMessage();
        this.viewModel.setOutputMessage(this.outputMessage);
    }

    /**
     * @param outputData the output to set as confirmation for edited playlist
     */
    public void setEditPlaylistConfirmation(editPlaylistOutputData outputData){
        this.outputMessage = outputData.getPlaylistEditedConfirmation();
        this.viewModel.setOutputMessage(this.outputMessage);
    }
}
