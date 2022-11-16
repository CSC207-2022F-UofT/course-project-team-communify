package InputData;

public class RegisterArtistInputData {
    private final String username;
    private final String password;
    private final String artistName;
    private boolean isArtist = true;

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
    /**
     * @return whether the user is an artist
     */
    public boolean isArtist() {
        return this.isArtist;
    }
}