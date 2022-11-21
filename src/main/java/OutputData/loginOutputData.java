package OutputData;

import Entities.Playlist;
import Entities.RegularUser;
import Entities.User;
import InputData.playlistInputData;

import java.util.ArrayList;

public class loginOutputData {
    private final User loggedIn;
    ArrayList<playlistInputData> playlists;

    public loginOutputData(User u, boolean isArtist){
        this.loggedIn = u;
        this.playlists = new ArrayList<>();

        if (!isArtist)
            createRegularUser();
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
}
