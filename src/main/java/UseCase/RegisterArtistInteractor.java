package UseCase;

import Database.SaveUserAccessInterface;
import Database.UserDsData;
import Database.UserList;
import Entities.User;
import Entities.userFactory;
import InputBoundary.RegisterArtistInputBoundary;
import InputData.RegisterArtistInputData;
import OutputBoundary.LoginOutputBoundary;

public class RegisterArtistInteractor implements RegisterArtistInputBoundary{
    private final LoginOutputBoundary registerPresenter;
    private final userFactory userFactory;

    private final SaveUserAccessInterface allUsers;

    public RegisterArtistInteractor(LoginOutputBoundary registerPresenter){
        this.allUsers = UserList.getInstance();
        this.registerPresenter =registerPresenter;
        this.userFactory = new userFactory();
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
        User user = this.userFactory.createArtistUser(registerInputData.getArtistName(),registerInputData.getUsername(),
                registerInputData.getPassword());
        allUsers.save(new UserDsData(user));
        //TODO: prepare success view
    }

}
