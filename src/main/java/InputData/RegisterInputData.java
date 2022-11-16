package InputData;

public class RegisterInputData {
    private final String username;
    private final String artistName;
    private final String password;
    private boolean isArtist;


    public RegisterInputData(String username, String password, String artistName, boolean isArtist) {
        this.username = username;
        this.isArtist = isArtist;
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
    /**
     * @return whether the user is an artist
     */
    public boolean isArtist() {
        return this.isArtist;
    }
}