package View;

import ViewModel.ArtistUserDsView;

public class InMemoryArtistUser implements ArtistUserDsView {
    private String username;
    private String name;

    public InMemoryArtistUser(String name, String username){
        this.name = name;
        this.username = username;
    }

    @Override
    public String getArtistName() {
        return this.name;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
}
