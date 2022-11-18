package Database;

import Entities.Song;
import Entities.User;
import Entities.userFactory;

import java.util.ArrayList;

/**
 * A data storage class in the Application Business Rules layer abstracting the interaction between database
 * classes and entities.
 */
public class userDsData {
    private final User user;

    /**
     * constructor for creation from use case to pass to database
     * @param u user object to encapsulate
     */
    public userDsData(User u){
        this.user = u;
    }

    /**
     * constructor for building an artistuser from the .csv database
     * @param username string username of user
     * @param password string password of user
     * @param artistName string artistname of user
     * @param songs string array of song ids owned by the user
     */
    public userDsData(String username, String password, String artistName, String[] songs){
        userFactory factory = new userFactory();
        GetSongAccessInterface songLibrary = Database.songLibrary.getInstance();
        ArrayList<Song> library = new ArrayList<>();

        for (String id : songs){
            songDsData song = songLibrary.getSong(Integer.parseInt(id));
            library.add(song.getSong());
        }

        this.user = factory.createArtistUser(artistName, username, password, library);
    }

    /**
     * constructor for building a regularuser from the .csv database
     * @param username string username of the user
     * @param password string password of the user
     * @param playlists string array of the playlist IDs belonging to the user
     */
    public userDsData(String username, String password, String[] playlists){
        userFactory factory = new userFactory();
        ArrayList<Integer> library = new ArrayList<>();

        for (String id : playlists){
            if (id.length() > 0)
                library.add(Integer.parseInt(id));
        }

        this.user = factory.createRegularUser(username, password, library);
    }

    /**
     * @return the User entity stored
     */
    public User getUser() {
        return user;
    }

    /**
     * @return the username of the User entity stored
     */
    public String getUsername() {
        return user.getUsername();
    }

    /**
     * @return the password of the User entity stored
     */
    public String getPassword(){
        return user.getPassword();
    }

    /**
     * @return builds the output to save this User to a file
     */
    public String[] buildOutput() {
        return this.user.toString().split(",");
    }
}
