package UseCase;

import Entities.User;
import OutputBoundary.loginOutputBoundary;
import OutputData.loginOutputData;
import InputData.RegisterInputData;
import InputBoundary.RegisterInputBoundary;
import Database.userAccessInterface;
import Database.userDsData;
import Entities.userFactory;

public class RegisterInteractor implements RegisterInputBoundary{
    private final loginOutputBoundary registerPresenter;
    private final userFactory userFactory;

    private final userAccessInterface allUsers;

    public RegisterInteractor(loginOutputBoundary registerPresenter){
        this.allUsers = Database.userList.getInstance();
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
        allUsers.save(new userDsData(user));
        loginOutputData userCreated = new loginOutputData(); //Todo: pass in value for loginOD
        //TODO: registerPresenter.successView(userCreated);
    }

}
