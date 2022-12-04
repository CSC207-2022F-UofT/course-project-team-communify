package entities;

import java.util.ArrayList;

/**
 * Entity which represents a User which is able to create and own playlists, and listen to music.
 */
public class RegularUser extends User {
    private final ArrayList<Integer> playlistList;

    /**
     * @param username string username of the user
     * @param password string password of the user
     */
    public RegularUser(String username, String password) {
        super(username, password);
        this.playlistList = new ArrayList<>();
    }

    /**
     * Overloaded constructor for Users which own playlists
     * @param username string username of the user
     * @param password string password of the user
     * @param playlist arraylist of Playlist IDs owned by the User
     */
    public RegularUser(String username, String password, ArrayList<Integer> playlist){
        super(username, password);
        this.playlistList = playlist;
    }

    /**
     * @return list of all Playlist objects owned by a User
     */
    public ArrayList<Integer> getPlaylistList() {
        return playlistList;
    }

    /**
     * @param p the new Playlist object owned by the User
     */
    public void addPlaylist(Playlist p){
        if (!playlistList.contains(p.getId()))
            playlistList.add(p.getId());
    }

    /**
     * @return String representation used for saving to database
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(getUsername() + "," + getPassword() + ",");

        for (Integer p : playlistList)
            output.append(p).append(";");

        if (playlistList.size() > 0)
            output.deleteCharAt(output.length() - 1);
        return output.toString();
    }
}
