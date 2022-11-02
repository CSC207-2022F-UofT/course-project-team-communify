package Entities;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Playlist {
    private String name;
    private User owner;
    private boolean isPublic;
    public LinkedList<Song> songList;
    private ArrayList<User> collaborators;

    public Playlist(String name, User owner, boolean isPublic){
        this.name = name;
        this.owner = owner;
        this.isPublic = isPublic;
        this.songList =  new LinkedList<Song>();
        this.collaborators = new ArrayList<User>();
        // creating an empty playlist
    }

    public Playlist(String name, User owner, boolean isPublic, Song song){
        this.name = name;
        this.owner = owner;
        this.isPublic = isPublic;
        this.songList =  new LinkedList<Song>();
        this.collaborators = new ArrayList<User>();
        this.songList.add(song);
        //overloaded constuctor for creating a non-empty playlist with one song

    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    // no set owner because the owner is permenantly set upon intilization

    public User getOwner(){
        return this.owner;
    }

    public void setPrivacy(boolean privacy){
        this.isPublic = privacy;
    }

    public boolean returnPrivacy(){
        return this.isPublic;
    }

    public void addCollaborators(User collaborator){
        this.collaborators.add(collaborator);
    }

    public ArrayList showCollaborators(){
        return this.collaborators;
    }


}
