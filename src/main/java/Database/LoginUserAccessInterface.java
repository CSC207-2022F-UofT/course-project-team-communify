package Database;

/**
 * Application Business Rules layer interface for accessing user data.
 */
public interface LoginUserAccessInterface {
    /**
     * @param username username of User password to check submitted password against
     * @param password password to be compared to database
     * @return true if and only if the submitted password matches the password in the database
     */
    boolean checkPassword(String username, String password);
}
