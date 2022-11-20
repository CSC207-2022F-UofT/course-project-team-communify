package UseCase;

import Database.UserList;
import Entities.User;
import OutputBoundary.LoginOutputBoundary;
import OutputData.LoginOutputData;
import InputData.RegisterInputData;
import InputBoundary.RegisterInputBoundary;
import Database.SaveUserAccessInterface;
import Database.UserDsData;
import Entities.userFactory;

public class RegisterInteractor implements RegisterInputBoundary{
    private final LoginOutputBoundary registerPresenter;
    private final userFactory userFactory;

    private final SaveUserAccessInterface allUsers;

    public RegisterInteractor(LoginOutputBoundary registerPresenter){
        this.allUsers = UserList.getInstance();
        this.registerPresenter =registerPresenter;
        this.userFactory = new userFactory();
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

        // create regular user
        User user = this.userFactory.createRegularUser(registerInputData.getUsername(), registerInputData.getPassword());
        allUsers.save(new UserDsData(user));
        LoginOutputData userCreated = new LoginOutputData(); //Todo: pass in value for loginOD
        //TODO: registerPresenter.successView(userCreated);
    }

}
