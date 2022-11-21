package OutputData;

import Entities.*;
import InputData.playlistInputData;
import InputData.songInputData;

import java.util.ArrayList;

public class loginOutputData {
    private final User loggedIn;
    private final boolean isArtist;
    private ArrayList<playlistInputData> playlists;
    private String artistName;
    private boolean correctType;

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

    private void createArtistUser() {
        try {
            ArtistUser artist = (ArtistUser) loggedIn;
            this.artistName = artist.getArtistName();
        } catch (ClassCastException e){
            this.correctType = false;
        }
    }

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

    public String getUsername(){
        return this.loggedIn.getUsername();
    }

    public ArrayList<playlistInputData> getPlaylists() {
        return playlists;
    }

    public boolean isArtist(){
        return isArtist;
    }

    public String getArtistName() {
        return artistName;
    }

    public boolean isCorrectType() {
        return correctType;
    }
}
