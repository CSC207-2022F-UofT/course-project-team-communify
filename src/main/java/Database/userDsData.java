package Database;

import Entities.User;

/**
 * A data storage class in the Application Business Rules layer abstracting the interaction between database
 * classes and entities.
 */
public class userDsData {
    private User user;

    public userDsData(){
        // TODO: default constructor to be removed once User classes implemented
    }

    public userDsData(User u){
        // constructor for creation from use case to pass to database
        this.user = u;
    }

    public userDsData(String username, String password, String artistName, String[] songs){
        // constructor for creation from database as artist
        // TODO: finish once User classes implemented
    }

    public userDsData(String username, String password, String[] playlists){
        // constructor for creation from database as artist
        // TODO: finish once User classes implemented
    }

    /**
     * @return the User entity stored
     */
    public User getUser() {
        return user;
    }

    /**
     * @return the username of the User entity stored
     */
    public String getUsername() {
        return user.getUsername();
    }

    /**
     * @return the password of the User entity stored
     */
    public String getPassword(){
        return user.getPassword();
    }
}
