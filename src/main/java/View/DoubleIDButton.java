package view;
import javax.swing.*;
public class DoubleIDButton extends JButton{

    private int playlistID;
    private int songID;

    /**
     *
     * @param playlistID ID of playlist
     * @param songID ID of song
     */

    public DoubleIDButton(int playlistID, int songID) {
        super();
        this.playlistID = playlistID;
        this.songID = songID;
    }
    /**
     *
     * @param playlistID ID of playlist
     * @param songID ID of song
     * @param text text of the button
     */
    public DoubleIDButton(int playlistID, int songID, String text){
        super(text);
        this.playlistID = playlistID;
        this.songID = songID;
    }

    /**
     *
     * @param playlistID playlist ID to set to
     */
    public void setPlaylistID(int playlistID){
        this.playlistID = playlistID;
    }

    /**
     *
     * @return ID of playlist
     */
    public int getPlaylistID(){
        return playlistID;
    }

    /**
     *
     * @param songID set the ID of the song
     */
    public void setSongID(int songID){
        this.songID = songID;
    }

    /**
     *
     * @return the ID of stored song
     */
    public int getSongID(){
        return songID;
    }

}
