package View;

import javax.swing.*;

public class IDButton extends JButton {
    private int id;

    public IDButton(int id){
        super();
        this.id = id;
    }

    public IDButton(int id, String text){
        super(text);
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
