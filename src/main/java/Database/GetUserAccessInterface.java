package Database;

/**
 * Application Business Rules layer interface for accessing user data.
 */
public interface GetUserAccessInterface {
    /**
     * @param username username to be queried in the database
     * @return User in userDsData object with submitted username, or null if that User does not exist
     */
    UserDsData getUser(String username);
}
