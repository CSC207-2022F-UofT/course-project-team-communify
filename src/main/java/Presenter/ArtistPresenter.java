package Presenter;

import OutputBoundary.LoginOutputBoundary;
import OutputData.LoginOutputData;
import ViewModel.ArtistUserDsView;
import ViewModel.UserViewModel;

/**
 * Interface adapters layer presenter for displaying artist user login and register use case output.
 */
public class ArtistPresenter implements LoginOutputBoundary {
    private final UserViewModel viewModel;
    private final ArtistUserDsView output;

    /**
     * @param vm the view model for the User view
     * @param out the presenter to return output data to
     */
    public ArtistPresenter(UserViewModel vm, ArtistUserDsView out){
        this.viewModel = vm;
        this.output = out;
    }

    @Override
    public void userLogIn(LoginOutputData data) {
        this.output.setUsername(data.getUsername());
        this.output.setArtistName(data.getArtistName());
        this.viewModel.updateCurrentUser(this.output);
    }
}
