package InputData;

public class RegisterInputData {
    private final String username;
    private final String password;

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