package UseCase;

import Database.SaveUserAccessInterface;
import Database.UserDsData;
import Database.UserList;
import Entities.User;
import Entities.UserFactory;
import InputBoundary.RegisterArtistInputBoundary;
import InputData.RegisterArtistInputData;
import OutputBoundary.LoginOutputBoundary;
import OutputData.LoginOutputData;
/**
 * Application business rules use case class to register an artist.
 */
public class RegisterArtistInteractor implements RegisterArtistInputBoundary{
    private final LoginOutputBoundary registerPresenter;
    private final UserFactory userFactory;

    private final SaveUserAccessInterface allUsers;

    /**
     * @param registerPresenter the register output presenter
     */
    public RegisterArtistInteractor(LoginOutputBoundary registerPresenter){
        this.allUsers = UserList.getInstance();
        this.registerPresenter = registerPresenter;
        this.userFactory = new UserFactory();
    }

    /**
     * @param registerInputData the input data of the new artist
     * @return true if the register is successful
     */
    @Override
    public boolean register(RegisterArtistInputData registerInputData){
        if (allUsers.exists(registerInputData.getUsername()) || registerInputData.getPassword().equals("") ||
                registerInputData.getUsername().equals("")){return false;}

        //create artist user
        User user = this.userFactory.createArtistUser(registerInputData.getArtistName(),registerInputData.getUsername(),
                registerInputData.getPassword());
        UserDsData newArtist = new UserDsData(registerInputData.getUsername(), registerInputData.getPassword(),
                registerInputData.getArtistName(), new String[0]);
        allUsers.save(newArtist);


        LoginOutputData userCreated = new LoginOutputData(user, true);
        registerPresenter.userLogIn(userCreated);
        return true;
    }

}
