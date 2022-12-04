package view;

import javax.swing.*;
/**
 * A view layer Button class with an ID field for songs and playlists.
 */
public class IDButton extends JButton {
    private int id;

    /**
     * @param id the ID to store
     */
    public IDButton(int id){
        super();
        this.id = id;
    }

    /**
     * @param id the ID to store
     * @param text the text of the button
     */
    public IDButton(int id, String text){
        super(text);
        this.id = id;
    }

    /**
     * @param id the ID of the song or playlist
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the ID of the song or playlist
     */
    public int getId() {
        return id;
    }
}
