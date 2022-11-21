package InputData;

public class loginInputData {
    private final String username;
    private final String password;
    private boolean isArtist;

    public loginInputData(String username, String password, boolean isArtist) {
        this.isArtist = isArtist;
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
    /**
     * @return whether the user is an artist
     */
    public boolean isArtist() {
        return this.isArtist;
    }
}