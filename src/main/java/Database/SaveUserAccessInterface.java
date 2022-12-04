package database;

/**
 * Application Business Rules layer interface for accessing user data.
 */
public interface SaveUserAccessInterface {
    /**
     * Saves a new user to the database.
     * @param u newly created User object in a userDsData object to be saved to the database
     */
    void save(UserDsData u);

    /**
     * A method to check whether a User exists by username.
     * @param username username to be queried in the database
     * @return true if and only if there exists a User of the name submitted
     */
    boolean exists(String username);
}
