package Presenter;

import OutputBoundary.loginOutputBoundary;
import OutputData.loginOutputData;
import ViewModel.ArtistUserDsView;
import ViewModel.UserDsView;
import ViewModel.userViewModel;

/**
 * Interface adapters layer presenter for displaying artist user login and register use case output.
 */
public class ArtistPresenter implements loginOutputBoundary {
    private final userViewModel viewModel;
    private final ArtistUserDsView output;

    /**
     * @param vm the view model for the User view
     * @param out the presenter to return output data to
     */
    public ArtistPresenter(userViewModel vm, ArtistUserDsView out){
        this.viewModel = vm;
        this.output = out;
    }

    @Override
    public void userLogIn(loginOutputData data) {
        this.output.setUsername(data.getUsername());
        this.output.setArtistName(data.getArtistName());
        this.viewModel.updateCurrentUser(this.output);
    }
}
