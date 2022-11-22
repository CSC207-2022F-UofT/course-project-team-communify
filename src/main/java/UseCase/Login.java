package UseCase;

import Database.LoginUserAccessInterface;
import InputBoundary.loginInputBoundary;
import InputData.loginInputData;
import OutputBoundary.loginOutputBoundary;
import Database.GetUserAccessInterface;
import OutputData.loginOutputData;
/**
 * Application business rules use case class to log in.
 */
public class Login implements loginInputBoundary{
    private final loginOutputBoundary loginPresenter;
    private final LoginUserAccessInterface loginUsers;
    private final GetUserAccessInterface getUsers;

    /**
     * @param loginPresenter the presenter for login output.
     */
    public Login(loginOutputBoundary loginPresenter) {
        this.loginUsers = Database.userList.getInstance();
        this.getUsers = Database.userList.getInstance();
        this.loginPresenter = loginPresenter;
    }

    /**
     * @param loginID the input data for logging in
     * @return true if the login is successful
     */
    @Override
    public boolean login(loginInputData loginID) {
        if (loginUsers.checkPassword(loginID.getUsername(), loginID.getPassword())){
            loginOutputData out = new loginOutputData(getUsers.getUser(loginID.getUsername()).getUser(),
                    loginID.isArtist());
            if (out.isCorrectType()){
                loginPresenter.userLogIn(out);
                return true;
            }
            return false;
        }
        return false;
    }
}
