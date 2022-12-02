package UseCase;

import Database.LoginUserAccessInterface;
import Database.UserList;
import InputBoundary.LoginInputBoundary;
import InputData.LoginInputData;
import OutputBoundary.LoginOutputBoundary;
import Database.GetUserAccessInterface;
import OutputData.LoginOutputData;
/**
 * Application business rules use case class to log in.
 */
public class LoginInteractor implements LoginInputBoundary {
    private final LoginOutputBoundary loginPresenter;
    private final LoginUserAccessInterface loginUsers;
    private final GetUserAccessInterface getUsers;

    /**
     * @param loginPresenter the presenter for login output.
     */
    public LoginInteractor(LoginOutputBoundary loginPresenter) {
        this.loginUsers = UserList.getInstance();
        this.getUsers = UserList.getInstance();
        this.loginPresenter = loginPresenter;
    }

    /**
     * @param loginID the input data for logging in
     * @return true if the login is successful
     */
    @Override
    public boolean login(LoginInputData loginID) {
        if (loginUsers.checkPassword(loginID.getUsername(), loginID.getPassword())){
            LoginOutputData out = new LoginOutputData(getUsers.getUser(loginID.getUsername()).getUser(),
                    loginID.isArtist());
            if (out.isCorrectType()){
                loginPresenter.userLogIn(out);
                return true;
            }
        }
        return false;
    }
}
