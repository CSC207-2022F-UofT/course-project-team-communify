package Entities;

public class PlaylistFactory {
    public Playlist createPlaylist(String name, User owner, boolean isPublic){
        return new Playlist(name,owner,isPublic);
    }
}
