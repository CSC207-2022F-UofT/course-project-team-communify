package OutputData;

import Entities.Playlist;
import Entities.Song;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Application Business Rules layer data structure for receiving playlist output from use cases.
 */
public class editPlaylistOutputData {
    private final String editConfirmation;
    private final List<Integer> songIDs;
    private final List<String> songNames;
    private final List<String[]> songArtists;
    private final List<String> songGenres;
    private final List<BufferedImage> songCovers;
    private final int playlistID;
    private final String playlistName;

    /**
     * @param editConfirmation the message to relay to the view
     * @param playlist the new playlist
     */
    public editPlaylistOutputData(String editConfirmation, Playlist playlist){
        this.editConfirmation = editConfirmation;
        this.playlistID = playlist.getId();
        this.playlistName = playlist.getName();
        songCovers = new ArrayList<>();
        songNames = new ArrayList<>();
        songArtists = new ArrayList<>();
        songGenres = new ArrayList<>();
        songIDs = new ArrayList<>();
        setSongData(playlist);
    }

    /**
     * @return the message to relay to the view
     */
    public String getPlaylistEditedConfirmation(){
        return this.editConfirmation;
    }

    /**
     * @param p the playlist to add the song data from
     */
    private void setSongData(Playlist p){
        System.out.println(p.getSongList().size());
        for (Song s : p.getSongList()){
            System.out.println(p.getSongList().indexOf(s));
            this.songNames.add(s.getName());
            this.songArtists.add(s.getArtistList());
            this.songCovers.add(s.getCover());
            this.songGenres.add(s.getGenre());
            this.songIDs.add(s.getID());
        }
    }

    /**
     * @return the playlist ID
     */
    public int getPlaylistID() {
        return playlistID;
    }

    /**
     * @return the name of the playlist
     */
    public String getPlaylistName() {
        return playlistName;
    }

    /**
     * @return the names of the songs
     */
    public List<String> getSongNames() {
        return songNames;
    }

    /**
     * @return the covers of the songs
     */
    public List<BufferedImage> getSongCovers() {
        return songCovers;
    }

    /**
     * @return the artists of the songs
     */
    public List<String[]> getSongArtists() {
        return songArtists;
    }

    /**
     * @return the genres of the songs
     */
    public List<String> getSongGenres() {
        return songGenres;
    }

    /**
     * @return the IDs of the songs
     */
    public List<Integer> getSongIDs() {
        return songIDs;
    }
}
