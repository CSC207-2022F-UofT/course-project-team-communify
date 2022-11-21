package UseCase;

import Database.SaveUserAccessInterface;
import Database.userDsData;
import Entities.User;
import Entities.userFactory;
import InputBoundary.RegisterArtistInputBoundary;
import InputData.RegisterArtistInputData;
import OutputBoundary.loginOutputBoundary;
import OutputData.loginOutputData;

public class RegisterArtistInteractor implements RegisterArtistInputBoundary{
    private final loginOutputBoundary registerPresenter;
    private final userFactory userFactory;

    private final SaveUserAccessInterface allUsers;

    public RegisterArtistInteractor(loginOutputBoundary registerPresenter){
        this.allUsers = Database.userList.getInstance();
        this.registerPresenter = registerPresenter;
        this.userFactory = new userFactory();
    }
    @Override
    public boolean register(RegisterArtistInputData registerInputData){
        if (allUsers.exists(registerInputData.getUsername()) || registerInputData.getPassword().equals("") ||
                registerInputData.getUsername().equals("")){return false;}

        //create artist user
        User user = this.userFactory.createArtistUser(registerInputData.getArtistName(),registerInputData.getUsername(),
                registerInputData.getPassword());
        userDsData newArtist = new userDsData(registerInputData.getUsername(), registerInputData.getPassword(),
                registerInputData.getArtistName(), new String[0]);
        allUsers.save(newArtist);


        loginOutputData userCreated = new loginOutputData(user, true);
        registerPresenter.userLogIn(userCreated);
        return true;
    }

}
