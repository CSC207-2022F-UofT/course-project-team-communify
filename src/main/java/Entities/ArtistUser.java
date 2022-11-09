package Entities;

import java.util.ArrayList;

public class ArtistUser extends User{
    private String artistName;

    public ArtistUser(String artistName, String username, String password){
        super(username, password);
        this.artistName = artistName;
    }
}
