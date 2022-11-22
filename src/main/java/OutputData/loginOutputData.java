package OutputData;

import Entities.*;
import InputData.playlistInputData;
import InputData.songInputData;

import java.util.ArrayList;
/**
 * Application Business Rules layer data structure for receiving login output from use cases.
 */
public class loginOutputData {
    private final User loggedIn;
    private final boolean isArtist;
    private ArrayList<playlistInputData> playlists;
    private String artistName;
    private boolean correctType;

    /**
     * @param u the new user
     * @param isArtist whether the user is an artist
     */
    public loginOutputData(User u, boolean isArtist){
        this.correctType = true;
        this.loggedIn = u;
        this.playlists = new ArrayList<>();
        this.isArtist = isArtist;

        if (!isArtist)
            createRegularUser();
        else
            createArtistUser();
    }

    /**
     * Creates an artist user.
     */
    private void createArtistUser() {
        try {
            ArtistUser artist = (ArtistUser) loggedIn;
            this.artistName = artist.getArtistName();
        } catch (ClassCastException e){
            this.correctType = false;
        }
    }

    /**
     * Creates a regular user.
     */
    private void createRegularUser() {
        try {
            RegularUser reg = (RegularUser) loggedIn;
            for (Integer p : reg.getPlaylistList()){
                playlists.add(new playlistInputData(p));
            }
        } catch (ClassCastException e){
            this.correctType = false;
        }
    }

    /**
     * @return the username of the user
     */
    public String getUsername(){
        return this.loggedIn.getUsername();
    }

    /**
     * @return the playlists of the user
     */
    public ArrayList<playlistInputData> getPlaylists() {
        return playlists;
    }

    /**
     * @return whether the user is an artist
     */
    public boolean isArtist(){
        return isArtist;
    }

    /**
     * @return the artist name of the user
     */
    public String getArtistName() {
        return artistName;
    }

    /**
     * @return if the attempted login is of a user of the correct type
     */
    public boolean isCorrectType() {
        return correctType;
    }
}
