package InputData;

import java.util.ArrayList;

public class playSpaceInputData {

    private final ArrayList<songInputData> spaceSongList;

    public playSpaceInputData(ArrayList<songInputData> spaceSongList) {
        this.spaceSongList = spaceSongList;
    }

    public ArrayList<songInputData> getSpaceSongList(){
        return this.spaceSongList;
    }
}
