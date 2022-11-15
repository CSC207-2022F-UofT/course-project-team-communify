package UseCase;
import Entities.User;
import OutputBoundary.loginOutputBoundary;
import OutputData.loginOutputData;
import InputData.loginInputData;
import InputBoundary.RegisterInputBoundary;
import Database.userAccessInterface;
import Database.userDsData;
import Entities.userFactory;

public class RegisterInteractor implements RegisterInputBoundary{
    private final loginOutputBoundary registerPresenter;
    private final userFactory userFactory;

    userAccessInterface Allusers;

    public RegisterInteractor(loginOutputBoundary registerPresenter, userAccessInterface Allusers, userFactory userFactory){
        this.Allusers = Allusers;
        this.registerPresenter =registerPresenter;
        this.userFactory = userFactory;
    }
    @Override
    public void register(loginInputData loginID){
        if (Allusers.exists(loginID.getUsername())){
            //TODO: prepare user exists failure view
        } else if (loginID.getPassword() == "") {
            //TODO: prepare no password failure view
        }

        if (loginID.isArtist()){
            User user = this.userFactory.createArtistUser("", loginID.getUsername(), loginID.getPassword());
            userDsData newUser = new userDsData(user);
            Allusers.save(newUser);
            //TODO: prepare success view
        }
        else {
            User user = this.userFactory.createRegularUser(loginID.getUsername(), loginID.getPassword());
            userDsData newUser = new userDsData(user);
            Allusers.save(newUser);
            //TODO: prepare success view
        }


    }

}
