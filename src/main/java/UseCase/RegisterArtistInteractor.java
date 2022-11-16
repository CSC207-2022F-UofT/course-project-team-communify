package UseCase;

import Database.userAccessInterface;
import Database.userDsData;
import Entities.User;
import Entities.userFactory;
import InputBoundary.RegisterArtistInputBoundary;
import InputData.RegisterArtistInputData;
import OutputBoundary.loginOutputBoundary;

public class RegisterArtistInteractor implements RegisterArtistInputBoundary{
    private final loginOutputBoundary registerPresenter;
    private final userFactory userFactory;

    userAccessInterface allUsers;

    public RegisterArtistInteractor(loginOutputBoundary registerPresenter, userAccessInterface allUsers,
                                    userFactory userFactory){
        this.allUsers = allUsers;
        this.registerPresenter =registerPresenter;
        this.userFactory = userFactory;
    }
    @Override
    public void register(RegisterArtistInputData registerInputData){
        if (allUsers.exists(registerInputData.getUsername())){
            //TODO: prepare user exists failure view
        } else if (registerInputData.getPassword() == "") {
            //TODO: prepare no password failure view
        } else if (registerInputData.getUsername() == "") {
            //TODO: prepare no username failure view
        }

        //create artist user
        User user;
        user = this.userFactory.createArtistUser(registerInputData.getArtistName(),registerInputData.getUsername(),
                registerInputData.getPassword());
        allUsers.save(new userDsData(user));
        //TODO: prepare success view
    }

}
