package InputData;
/**
 * Application Business Rules layer data structure for submitting register input to use cases.
 */
public class RegisterInputData {
    private final String username;
    private final String password;

    /**
     * @param username the username of the new user
     * @param password the password of the new user
     */
    public RegisterInputData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * @return the name of user
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * @return the password of user
     */
    public String getPassword() {
        return this.password;
    }
}