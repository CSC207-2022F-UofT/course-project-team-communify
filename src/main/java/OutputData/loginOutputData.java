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

    public loginOutputData(User u, boolean isArtist){
        this.loggedIn = u;
        this.playlists = new ArrayList<>();
        this.isArtist = isArtist;

        if (!isArtist)
            createRegularUser();
        else
            createArtistUser();
    }

    private void createArtistUser() {
        ArtistUser artist = (ArtistUser) loggedIn;
        this.artistName = artist.getArtistName();
    }

    private void createRegularUser() {
        RegularUser reg = (RegularUser) loggedIn;
        for (Integer p : reg.getPlaylistList()){
            playlists.add(new playlistInputData(p));
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
}
