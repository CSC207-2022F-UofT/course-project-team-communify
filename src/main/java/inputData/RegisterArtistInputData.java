package inputData;
/**
 * Application Business Rules layer data structure for submitting register artist to use cases.
 */
public class RegisterArtistInputData {
    private final String username;
    private final String password;
    private final String artistName;

    /**
     * @param username the username of the artist
     * @param password the password of the artist
     * @param artistName the name of the artist
     */
    public RegisterArtistInputData(String username, String password, String artistName) {
        this.username = username;
        this.artistName = artistName;
        this.password = password;
    }

    /**
     * @return the name of user
     */
    public String getUsername() {
        return this.username;
    }
    /**
     * @return the artistName of user
     */
    public String getArtistName() {
        return this.artistName;
    }
    /**
     * @return the password of user
     */
    public String getPassword() {
        return this.password;
    }
}