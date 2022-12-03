package UseCase;

import Database.UserList;
import Entities.User;
import OutputBoundary.LoginOutputBoundary;
import OutputData.LoginOutputData;
import InputData.RegisterInputData;
import InputBoundary.RegisterInputBoundary;
import Database.SaveUserAccessInterface;
import Database.UserDsData;
import Entities.UserFactory;
/**
 * Application business rules use case class to register a user.
 */
public class RegisterInteractor implements RegisterInputBoundary{
    private final LoginOutputBoundary registerPresenter;
    private final UserFactory userFactory;

    private final SaveUserAccessInterface allUsers;

    /**
     * @param registerPresenter the register output presenter
     */
    public RegisterInteractor(LoginOutputBoundary registerPresenter){
        this.allUsers = UserList.getInstance();
        this.registerPresenter =registerPresenter;
        this.userFactory = new UserFactory();
    }

    /**
     * @param registerInputData the input data of the new user
     * @return true if the register is successful
     */
    @Override
    public boolean register(RegisterInputData registerInputData){
        if (allUsers.exists(registerInputData.getUsername()) || registerInputData.getPassword().equals("") ||
                registerInputData.getUsername().equals("")){return false;}

        // create regular user
        User user = this.userFactory.createRegularUser(registerInputData.getUsername(), registerInputData.getPassword());
        allUsers.save(new UserDsData(user));
        LoginOutputData userCreated = new LoginOutputData(user, false);
        registerPresenter.userLogIn(userCreated);
        return true;
    }

}
