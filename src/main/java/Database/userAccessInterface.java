package Database;

import Entities.User;

/**
 * Application Business Rules layer interface for accessing user data.
 */
public interface userAccessInterface {
    /**
     * Saves a new user to the database.
     * @param u newly created User object to be saved to the database
     */
    public void save(User u);

    /**
     * @param username username to be queried in the database
     * @return User object with submitted username, or null if that User does not exist
     */
    public User getUser(String username);

    /**
     * A method to check whether a User exists by username.
     * @param username username to be queried in the database
     * @return true if and only if there exists a User of the name submitted
     */
    public boolean exists(String username);

    /**
     * @param username username of User password to check submitted password against
     * @param password password to be compared to database
     * @return true if and only if the submitted password matches the password in the database
     */
    public boolean checkPassword(String username, String password);

}
