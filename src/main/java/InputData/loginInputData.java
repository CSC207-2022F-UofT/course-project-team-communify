package InputData;

/**
 * Application Business Rules layer data structure for submitting login input to use cases.
 */
public class loginInputData {
    private final String username;
    private final String password;
    private final boolean isArtist;

    /**
     * @param username username of user
     * @param password password of user
     * @param isArtist true if the user is an artist
     */
    public loginInputData(String username, String password, boolean isArtist) {
        this.username = username;
        this.password = password;
        this.isArtist = isArtist;
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
    /**
     * @return whether user is artist
     */
    public boolean isArtist() {
        return this.isArtist;
    }
}