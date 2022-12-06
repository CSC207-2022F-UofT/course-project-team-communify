package view;
import javax.swing.*;

/**
 * A JButton that can store two IDs
 */
public class DoubleIDButton extends JButton{

    private final int playlistID;
    private final int songID;

    /**
     *
     * @param playlistID ID of playlist
     * @param songID ID of song
     * @param icon Icon of the button
     */
    public DoubleIDButton(int playlistID, int songID, ImageIcon icon){
        super(icon);
        this.playlistID = playlistID;
        this.songID = songID;
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
     * @return the ID of stored song
     */
    public int getSongID(){
        return songID;
    }

}
