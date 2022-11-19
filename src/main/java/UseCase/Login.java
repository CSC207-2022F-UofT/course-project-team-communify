package UseCase;

import InputBoundary.loginInputBoundary;
import InputData.loginInputData;
import OutputBoundary.loginOutputBoundary;
import Database.GetUserAccessInterface;

public class Login implements loginInputBoundary{
    private final loginOutputBoundary loginPresenter;
    private final GetUserAccessInterface allUsers;

    public Login(loginOutputBoundary loginPresenter) {
        this.allUsers = Database.userList.getInstance();
        this.loginPresenter = loginPresenter;
    }

    @Override
    public void login(loginInputData loginID) {
        //TODO: currently implementing
    }
}
