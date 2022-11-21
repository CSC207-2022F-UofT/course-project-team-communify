package Presenter;

import OutputBoundary.loginOutputBoundary;
import OutputData.loginOutputData;
import ViewModel.ArtistUserDsView;
import ViewModel.UserDsView;
import ViewModel.userViewModel;

public class ArtistPresenter implements loginOutputBoundary {
    private final userViewModel viewModel;
    private final ArtistUserDsView output;

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
