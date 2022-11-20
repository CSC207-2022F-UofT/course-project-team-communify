package UseCase;

import Database.UserList;
import InputBoundary.LoginInputBoundary;
import InputData.LoginInputData;
import OutputBoundary.LoginOutputBoundary;
import Database.GetUserAccessInterface;

public class Login implements LoginInputBoundary {
    private final LoginOutputBoundary loginPresenter;
    private final GetUserAccessInterface allUsers;

    public Login(LoginOutputBoundary loginPresenter) {
        this.allUsers = UserList.getInstance();
        this.loginPresenter = loginPresenter;
    }

    @Override
    public void login(LoginInputData loginID) {
        //TODO: currently implementing
    }
}
