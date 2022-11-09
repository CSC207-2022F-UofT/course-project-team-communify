package Entities;

import java.util.ArrayList;

public class ArtistUser extends User{
    private String artistName;
    private String username;
    private String password;

    public ArtistUser(String artistName, String username, String password){
        super(username, password);
        this.artistName = artistName;
    }
}
