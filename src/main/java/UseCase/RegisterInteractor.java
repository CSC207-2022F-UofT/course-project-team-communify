package UseCase;
import Entities.User;
import OutputBoundary.loginOutputBoundary;
import InputData.RegisterInputData;
import InputBoundary.RegisterInputBoundary;
import Database.userAccessInterface;
import Database.userDsData;
import Entities.userFactory;

public class RegisterInteractor implements RegisterInputBoundary{
    private final loginOutputBoundary registerPresenter;
    private final userFactory userFactory;

    userAccessInterface allUsers;

    public RegisterInteractor(loginOutputBoundary registerPresenter, userAccessInterface allUsers,
                              userFactory userFactory){
        this.allUsers = allUsers;
        this.registerPresenter =registerPresenter;
        this.userFactory = userFactory;
    }
    @Override
    public void register(RegisterInputData registerInputData){
        if (allUsers.exists(registerInputData.getUsername())){
            //TODO: prepare user exists failure view
        } else if (registerInputData.getPassword() == "") {
            //TODO: prepare no password failure view
        } else if (registerInputData.getUsername() == "") {
            //TODO: prepare no username failure view
        }

        User user;
        if (registerInputData.isArtist()){
            // if is artist, create artist user
            user = this.userFactory.createArtistUser(registerInputData.getArtistName(), registerInputData.getUsername(),
                    registerInputData.getPassword());
            //TODO: prepare success view
        }
        else {
            // create regular user
            user = this.userFactory.createRegularUser(registerInputData.getUsername(), registerInputData.getPassword());
            //TODO: prepare success view
        }
        allUsers.save(new userDsData(user));


    }

}
