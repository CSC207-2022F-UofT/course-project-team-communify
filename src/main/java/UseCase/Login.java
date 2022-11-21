package UseCase;

import Database.LoginUserAccessInterface;
import InputBoundary.loginInputBoundary;
import InputData.loginInputData;
import OutputBoundary.loginOutputBoundary;
import Database.GetUserAccessInterface;
import OutputData.loginOutputData;

public class Login implements loginInputBoundary{
    private final loginOutputBoundary loginPresenter;
    private final LoginUserAccessInterface loginUsers;
    private final GetUserAccessInterface getUsers;

    public Login(loginOutputBoundary loginPresenter) {
        this.loginUsers = Database.userList.getInstance();
        this.getUsers = Database.userList.getInstance();
        this.loginPresenter = loginPresenter;
    }

    @Override
    public boolean login(loginInputData loginID) {
        if (loginUsers.checkPassword(loginID.getUsername(), loginID.getPassword())){
            loginOutputData out = new loginOutputData(getUsers.getUser(loginID.getUsername()).getUser(),
                    loginID.isArtist());
            loginPresenter.userLogIn(out);
            return true;
        }
        return false;
    }
}
