package InputData;

import java.util.ArrayList;

/**
 * Application Business Rules layer data structure for submitting space input to use cases.
 */
public class playSpaceInputData {

    private final ArrayList<songInputData> spaceSongList;

    public playSpaceInputData(ArrayList<songInputData> spaceSongList) {
        this.spaceSongList = spaceSongList;
    }

    /**
     * @return the song list queue of the space
     */
    public ArrayList<songInputData> getSpaceSongList(){
        return this.spaceSongList;
    }
}
