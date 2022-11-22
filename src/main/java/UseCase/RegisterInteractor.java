package UseCase;

import Entities.User;
import OutputBoundary.loginOutputBoundary;
import OutputData.loginOutputData;
import InputData.RegisterInputData;
import InputBoundary.RegisterInputBoundary;
import Database.SaveUserAccessInterface;
import Database.userDsData;
import Entities.userFactory;

public class RegisterInteractor implements RegisterInputBoundary{
    private final loginOutputBoundary registerPresenter;
    private final userFactory userFactory;

    private final SaveUserAccessInterface allUsers;

    public RegisterInteractor(loginOutputBoundary registerPresenter){
        this.allUsers = Database.userList.getInstance();
        this.registerPresenter =registerPresenter;
        this.userFactory = new userFactory();
    }
    @Override
    public boolean register(RegisterInputData registerInputData){
        if (allUsers.exists(registerInputData.getUsername()) || registerInputData.getPassword().equals("") ||
                registerInputData.getUsername().equals("")){return false;}

        // create regular user
        User user = this.userFactory.createRegularUser(registerInputData.getUsername(), registerInputData.getPassword());
        allUsers.save(new userDsData(user));
        loginOutputData userCreated = new loginOutputData(user, false);
        registerPresenter.userLogIn(userCreated);
        return true;
    }

}
